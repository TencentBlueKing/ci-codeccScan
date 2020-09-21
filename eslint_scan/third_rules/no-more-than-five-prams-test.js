// 这是一个示例，用于检查函数的参数不能超过5个
"use strict";

module.exports = {
    meta: {
        type: "suggestion",
        docs: {
            description: "enforce a maximum number of parameters in function definitions",
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
        let numParams = 5;
        function checkFunction(node) {
            if (node.params.length > numParams) {
                context.report({
                    node,
                    messageId: "msg1",  //此处为meta里定义的messages的id
                    data: {
                        name: node.id.name,  //messages.exceed中{{name}}占位符
                        count: node.params.length, //messages.exceed中{{count}}占位符
                        max: numParams //messages.exceed中{{max}}占位符
                    }
                });
            }
        }
        return {
            //如果当前遍历的node类型为FunctionDeclaration，
            //则调用checkFunction函数做处理
            FunctionDeclaration: checkFunction,
        };
    }
};