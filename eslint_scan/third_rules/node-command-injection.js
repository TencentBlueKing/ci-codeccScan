"use strict";

module.exports = {
    meta: {
        type: "suggestion",
        docs: {
            description: "find command injection bugs",
            category: "Stylistic Issues",
            recommended: false,
            url: ""
        },
        schema: [],
        messages: {
            msg1: "{{name}} has too many parameters ({{count}}). Maximum allowed is {{max}}."
        }
    },
    create(context) {
      
        var httpVarArr = "";
        var assignVar = "";
        var is_child_process_enabled = "false";
        var suspiciousVars = [];
        var functionParamVars = [];
      
    function initFunctionCheck(node){
          
      suspiciousVars = [];
      functionParamVars = [];
      // console.log(node.params);
      if (node.params !== undefined){  
        for (let funcParamIndex = 0; funcParamIndex < node.params.length; funcParamIndex++){
            functionParamVars.push(node.params[funcParamIndex].name);
        }               
      }
      
    }
              
    // 获取输入点（URL参数名）
    function checkVariableDeclarator(node) {
          
          // console.log(functionParamVars);
          // console.log(node.init.type);
          if(node.init !== null){
            
              if(node.init.type == 'MemberExpression' && node.init.object !== undefined){
                
                //console.log(node.init.object.name);
                if(node.init.object.type == 'MemberExpression' && node.init.object.property.name !== undefined ){
                    // 适配：req.body、req.cookies、req.params、req.query
                    if (node.init.object.property.name == "params" | node.init.object.property.name == "body" | node.init.object.property.name == "query" | node.init.object.property.name == "cookies"){
                        httpVarArr = node.id.name;
                        //console.log(httpVarArr);
                    }                   
                } else if (node.init.type == 'MemberExpression' && node.init.object.name !== undefined ){                  
                     if (node.init.object.name == "params"){
                        httpVarArr = node.id.name;
                        //console.log(httpVarArr);
                     }  
                  
                } else {
                   if (node.init.property.name == "params"){
                      //httpVarArr.push(node.id.name);
                      httpVarArr = node.id.name;
                      //console.log(httpVarArr);
                   }
                 }
                
              } else if(node.init.type == 'CallExpression'){
                    // 适配：var xxx = code.toLowerCase();
                    if (node.init.callee.object !== undefined) {
                       if (httpVarArr == node.init.callee.object.name){
                           assignVar = node.id.name;
                       } else if (node.init.callee.property.name == "param"){
               httpVarArr = node.id.name;
                           // console.log(httpVarArr);                    
                       } 
                       
                    } else {
                         
                      // 适配：var xxx = toLowerCase(xx);
                      for (let arName = 0; arName < node.init.arguments.length; arName++){
                          // console.log(httpVarArr);
                          // console.log(node.init.arguments[arName].name);
                          // 代表传入参数值被赋值给了等式左侧的变量，故覆盖掉assignVar
                          if (httpVarArr == node.init.arguments[arName].name){
                              assignVar = node.id.name;
                          }
                       }                      
                      
                    } 
              } else if (node.init.type == 'TemplateLiteral'){
                   if(node.init.expressions !== undefined){
                      // console.log(functionParamVars);
                      // console.log(suspiciousVars);

                      for (let expressionIndex = 0; expressionIndex < node.init.expressions.length; expressionIndex++){
                          if(functionParamVars.indexOf(node.init.expressions[expressionIndex].name) > -1 | suspiciousVars.indexOf(node.init.expressions[expressionIndex].name) > -1){
                            suspiciousVars.push(node.id.name);
                          }
                       }         
                     
                   }      
              } else if(node.init.type == 'Identifier'){
                   if (httpVarArr == node.init.name){
                       assignVar = node.id.name;
                   }
              } 
              
            }
          
        }
      
        // 追踪变量赋值传递
        function checkAssignment(node){
          
           if (node.right !== undefined) {
             
             if (node.right.type == 'CallExpression') {
              
               if (node.right.callee.object !== undefined) {
                   
                   // 示例：xxx = code.toLowerCase();
                   if (httpVarArr == node.right.callee.object.name){
                       assignVar = node.left.name;
                   } else if (assignVar == node.right.callee.object.name) {
                       assignVar = node.left.name;
                   } else if (node.right.arguments !== undefined ){
                       for (let arRightName = 0; arRightName < node.right.arguments.length; arRightName++){
                          if (httpVarArr == node.right.arguments[arRightName].name){
                              assignVar = node.left.name;
                          }
                        } 
                   }

                } else {
                 for (let arName = 0; arName < node.right.arguments.length; arName++){
                    // console.log(httpVarArr);
                    // console.log(node.right.arguments[arName].name);
                    // 代表传入参数值被赋值给了等式左侧的变量，故覆盖掉assignVar
                    if (httpVarArr == node.right.arguments[arName].name){
                        assignVar = node.left.name;
                    }
                 }
               }
               
             } else if (node.right.type == 'MemberExpression' && node.right.object !== undefined){
                if (httpVarArr == node.right.object.name){
                  assignVar = node.left.name;
                    //console.log(assignVar);
                } else if(assignVar == node.right.object.name){
                  assignVar = node.left.name;
                    //console.log(assignVar);                
                }
             } else if(node.right.type == "Identifier"){
                
               if (assignVar == node.right.name){
                   assignVar = node.left.name;
               }
             
             } else if (node.right.type == "BinaryExpression") {
               // 示例：'1' + code.log
               if (node.right.left.type == "Identifier"){
                   if ( assignVar == node.right.left.name || httpVarArr == node.right.left.name){
                       assignVar = node.left.name;
                   }
               } else if (node.right.right.type == "Identifier"){
           if ( assignVar == node.right.right.name || httpVarArr == node.right.right.name){
                       assignVar = node.left.name;
                   }                          
               }
                        
             } else if(node.right.type == "ArrayExpression"){
               
               if (node.right.elements !== undefined ){
                 for (let arNameArray = 0; arNameArray < node.right.elements.length; arNameArray++){
                    if (assignVar == node.right.elements[arNameArray].name){
                        assignVar = node.left.name;
                        console.log(assignVar);
                    } else if(httpVarArr == node.right.elements[arNameArray].name) {
                        assignVar = node.left.name;      
                    }
                 }
               }
               
             }
             
           }
        }
      
        // 检查高危函数
        function checkCalleeEval(node) {
           
            // console.log(is_child_process_enabled);
            // console.log(suspiciousVars);
            
            if (node.callee.name !== undefined) {
              
              // 检查是否引入“child_process”包
              if (node.callee.name.toLowerCase() == "require") {
                  if(node.arguments[0].type == "Literal" & node.arguments[0].value == "child_process"){
                     is_child_process_enabled = "true";
                  }
              }               
              
              if (node.callee.name.toLowerCase() === "exec" && node.arguments[0].type !== 'Literal') {

                  // 告警[1] URL参数赋值变量经传递后，传入eval()
                  // 样例：
                  // exec(s3command, (err, stdout, stderr) => {
                  // if (err) reject(err);
                  // else if (stderr !== '') reject(new Error(stderr));
                  // else resolve(stdout.slice(0, -1));
                  // });
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  if (node.arguments[0].type == "Identifier"){
                    if (assignVar == node.arguments[0].name){
                      if (is_child_process_enabled == "true"){
                        context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                      }
                    } else if (suspiciousVars.indexOf(node.arguments[0].name)){
                      if (is_child_process_enabled == "true"){
                        context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].name);
                      }
                    }
                  }

                  // 告警[2] exec()内直接执行参数值
                  // 样例：
                  // tsteam.exec(req.body.param, func);
                  if (node.arguments[0].type == 'MemberExpression' && node.arguments[0].object!== undefined){
                    //console.log(node.arguments[0].object);
                    if(node.arguments[0].object.name == 'params' | node.arguments[0].object.name == 'body'){
                      //console.log(node.arguments[0].object.name);
                      //console.log(node.arguments[0].property.name);
                      if (is_child_process_enabled == "true"){
                        context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                      }
                    } else if(node.arguments[0].object.property != undefined){
                       // eval(req.body.eqn)
                       if (node.arguments[0].object.property.name == "body" | node.arguments[0].object.property.name == "params"){
                         if (is_child_process_enabled == "true"){
                          context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                         }
                       }
                    }
                  }

                  // 告警[3] exec()执行拼接的变量
                  // 样例：
                  // tsteam.exec('1' + s3command, func);
                  // tsteam.exec(s3command + '1', func);
                  if (node.arguments[0].type == 'BinaryExpression'){
                      if (node.arguments[0].left !== undefined & node.arguments[0].left.type == "Identifier"){
                          if (is_child_process_enabled == "true"){
                            context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].left.name + " 。");
                          }
                      } else if (node.arguments[0].right !== undefined & node.arguments[0].right.type == "Identifier"){
                          if (is_child_process_enabled == "true"){
                            context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].right.name + " 。");  
                          }
                      } else if (node.arguments[0].left !== undefined & node.arguments[0].left.type == "MemberExpression"){
                          if (node.arguments[0].left.object.property.name == "body" | node.arguments[0].left.object.property.name == "params" | node.arguments[0].left.object.property.name == "query"){
                            if (is_child_process_enabled == "true"){
                              context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].left.property.name + " 。");  
                            }      
                          }
                      } else if (node.arguments[0].right !== undefined & node.arguments[0].right.type == "MemberExpression"){
                          if (node.arguments[0].right.object.property.name == "body" | node.arguments[0].right.object.property.name == "params" | node.arguments[0].right.object.property.name == "query"){
                            if (is_child_process_enabled == "true"){
                              context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].right.property.name + " 。");  
                            }   
                      	  }
                        
                      }
                  }
                  
               } 
            } else if (node.callee.type == "MemberExpression") {
                  if(node.callee.property.name !== undefined & node.callee.property.name.toLowerCase() === "exec"){
                      
                      // 告警[1] URL参数赋值变量经传递后，传入eval()
                      // 样例：
                      // exec(s3command, (err, stdout, stderr) => {
                      // if (err) reject(err);
                      // else if (stderr !== '') reject(new Error(stderr));
                      // else resolve(stdout.slice(0, -1));
                      // });
                      // 参数值：
                      // assignVar：最终传递的变量
                      // httpVarArr：取参后首次赋值的变量
                      if (node.arguments[0].type == "Identifier"){
                        if (assignVar == node.arguments[0].name){
                          if (is_child_process_enabled == "true"){
                            context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                          }
                        } else if (suspiciousVars.indexOf(node.arguments[0].name)){
                          if (is_child_process_enabled == "true"){
                            context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].name);
                          }
                        }
                      }

                      // 告警[2] exec()内直接执行参数值
                      // 样例：
                      // tsteam.exec(req.body.param, func);
                      if (node.arguments[0].type == 'MemberExpression' && node.arguments[0].object!== undefined){
                        if(node.arguments[0].object.name == 'params' | node.arguments[0].object.name == 'body'){
                          if (is_child_process_enabled == "true"){
                            context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                          }
                        } else if(node.arguments[0].object.property != undefined){
                           // eval(req.body.eqn)
                           if (node.arguments[0].object.property.name == "body" | node.arguments[0].object.property.name == "params"){
                             if (is_child_process_enabled == "true"){
                              context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                             }
                           }
                        }
                      }

                      // 告警[3] exec()执行拼接的变量
                      // 样例：
                      // tsteam.exec('1' + s3command, func);
                      // tsteam.exec(s3command + '1', func);
                      if (node.arguments[0].type == 'BinaryExpression'){
                          if (node.arguments[0].left !== undefined & node.arguments[0].left.type == "Identifier"){
                              if (is_child_process_enabled == "true"){
                                context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].left.name + " 。");
                              }
                          } else if (node.arguments[0].right !== undefined & node.arguments[0].right.type == "Identifier"){
                              if (is_child_process_enabled == "true"){
                                context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].right.name + " 。");    
                              }
                          } else if (node.arguments[0].left !== undefined & node.arguments[0].left.type == "MemberExpression"){
                            if (node.arguments[0].left.object.property.name == "body" | node.arguments[0].left.object.property.name == "params" | node.arguments[0].left.object.property.name == "query"){
                              if (is_child_process_enabled == "true"){
                                context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].left.property.name + " 。");  
                              }      
                            }
                          } else if (node.arguments[0].right !== undefined & node.arguments[0].right.type == "MemberExpression"){
                            if (node.arguments[0].right.object.property.name == "body" | node.arguments[0].right.object.property.name == "params" | node.arguments[0].right.object.property.name == "query"){
                              if (is_child_process_enabled == "true"){
                                context.report(node, "[命令注入风险] exec函数执行了可疑变量：" + node.arguments[0].right.property.name + " 。");  
                              }   
                            }                        
                      	  }
                      }
                  }
            }
        }
      
        return {
            //如果当前遍历的node类型为FunctionDeclaration，
            //则调用checkFunction函数做处理
            FunctionDeclaration: initFunctionCheck,
            VariableDeclarator: checkVariableDeclarator,
            AssignmentExpression: checkAssignment,
            CallExpression: checkCalleeEval,
        };
    }
};