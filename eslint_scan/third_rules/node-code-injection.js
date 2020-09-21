"use strict";

module.exports = {
    meta: {
        type: "suggestion",
        docs: {
            description: "find code injection bugs",
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
      
        function initFunctionCheck(node){
            httpVarArr = "";
        	assignVar = "";
        }
            	
      	// 获取输入点（URL参数名）
		function checkVariableDeclarator(node) {
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
                       for (let arName = 0; arName < node.init.arguments.length; arName++){
                          // console.log(httpVarArr);
                          // console.log(node.init.arguments[arName].name);
                          // 代表传入参数值被赋值给了等式左侧的变量，故覆盖掉assignVar
                          if (httpVarArr == node.init.arguments[arName].name){
                              assignVar = node.id.name;
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
             
             if (node.right.type == 'CallExpression')	{
              
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
                        console.log(assignVar);
                    }
                 }
               }
               
             }
             
           }
          
        }
      
        // 检查高危函数
        function checkCalleeEval(node) {
                              
            
            if (node.callee.name !== undefined) {
              
              if (node.callee.name.toLowerCase() === "eval" && node.arguments[0].type !== 'Literal') {
                  // console.log(assignVar);
                  // console.log(httpVarArr);
                  // console.log(node.arguments[0].name);

                  // 告警[1] URL参数赋值变量经传递后，传入eval()
                  // 样例：
                  // foo = params.log;
                  // eval(foo)
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  if ( assignVar == node.arguments[0].name){
                     context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

                  // 告警[2] eval()内直接执行参数值
                  // 样例：
                  // eval(params.log)
                  // 参数值：
                  // node.arguments[0].object.name：Node.js取参对象一般是params
                  // node.arguments[0].property.name：URL参数名
                  if (node.arguments[0].type == 'MemberExpression' && node.arguments[0].object!== undefined){
                    //console.log(node.arguments[0].object);
                    if(node.arguments[0].object.name == 'params' | node.arguments[0].object.name == 'body'){
                      //console.log(node.arguments[0].object.name);
                      //console.log(node.arguments[0].property.name);
                      context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                    } else if(node.arguments[0].object.property.name == "body" | node.arguments[0].object.property.name == "params"){
                      // eval(req.body.eqn)
                      context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                    }
                  }

              } else if(node.callee.name.toLowerCase() === "settimeout" && node.arguments[0].type !== 'Literal'){

                  // 告警[3] URL参数赋值变量经传递后，传入setTimeOut()
                  // 样例：
                  // foo = params.log;
                  // setTimeOut(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setTimeOut函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              } else if(node.callee.name.toLowerCase() === "setinterval" && node.arguments[0].type !== 'Literal'){

                  // 告警[4] URL参数赋值变量经传递后，setInterval()
                  // 样例：
                  // foo = params.log;
                  // setInterval(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setInterval函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              } else if(node.callee.name.toLowerCase() === "setimmediate" && node.arguments[0].type !== 'Literal'){

                  // 告警[4] URL参数赋值变量经传递后，setImmediate()
                  // 样例：
                  // foo = params.log;
                  // setImmediate(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setImmediate函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              }
            
            } else if(node.callee.object !== undefined) {
              
              // eval附着于对象上
              // tst.eval(req.body.eqn)
              if (node.callee.property.name.toLowerCase() === "eval" && node.arguments[0].type !== 'Literal') {

                  // 告警[1] URL参数赋值变量经传递后，传入eval()
                  // 样例：
                  // foo = params.log;
                  // eval(foo)
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  if ( assignVar == node.arguments[0].name){
                     context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

                  // 告警[2] eval()内直接执行参数值
                  // 样例：
                  // eval(params.log)
                  // 参数值：
                  // node.arguments[0].object.name：Node.js取参对象一般是params
                  // node.arguments[0].property.name：URL参数名
                  if (node.arguments[0].type == 'MemberExpression' && node.arguments[0].object!== undefined){
                    //console.log(node.arguments[0].object);
                    if(node.arguments[0].object.name == 'params' | node.arguments[0].object.name == 'body'){
                      //console.log(node.arguments[0].object.name);
                      //console.log(node.arguments[0].property.name);
                      context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                    } else if(node.arguments[0].object.property.name == "body" | node.arguments[0].object.property.name == "params"){
                      // eval(req.body.eqn)
                      context.report(node, "[代码注入风险] eval函数执行了可疑变量：" + node.arguments[0].property.name + " 。");
                    }
                  }                
                
              } else if(node.callee.property.name.toLowerCase() === "settimeout" && node.arguments[0].type !== 'Literal'){

                  // 告警[3] URL参数赋值变量经传递后，传入setTimeOut()
                  // 样例：
                  // foo = params.log;
                  // setTimeOut(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setTimeOut函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              } else if(node.callee.property.name.toLowerCase() === "setinterval" && node.arguments[0].type !== 'Literal'){

                  // 告警[4] URL参数赋值变量经传递后，setInterval()
                  // 样例：
                  // foo = params.log;
                  // setInterval(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setInterval函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              } else if(node.callee.property.name.toLowerCase() === "setimmediate" && node.arguments[0].type !== 'Literal'){

                  // 告警[4] URL参数赋值变量经传递后，setImmediate()
                  // 样例：
                  // foo = params.log;
                  // setImmediate(foo, '1')
                  // 参数值：
                  // assignVar：最终传递的变量
                  // httpVarArr：取参后首次赋值的变量
                  // console.log(assignVar);
                  //console.log(node.arguments[0].name);
                  if ( assignVar == node.arguments[0].name){
                      context.report(node, "[代码注入风险] setImmediate函数执行了可疑变量：" + assignVar + " ; " + "污点追踪所得的原始变量为：" + httpVarArr + " 。");
                  }

              }
              
            }
        }
      
        return {
            //如果当前遍历的node类型为FunctionDeclaration，
            //则调用checkFunction函数做处理
            //FunctionExpression: initFunctionCheck,
            VariableDeclarator: checkVariableDeclarator,
            AssignmentExpression: checkAssignment,
            CallExpression: checkCalleeEval,
        };
    }
};