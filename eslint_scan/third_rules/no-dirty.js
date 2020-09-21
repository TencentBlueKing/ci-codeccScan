"use strict";
const regs = [
  "asshole",
  "suck",
  "damn",
  "pussy",
  "bitch",
  "fuck",
  "dick",
  "cock",
  "叼",
  "屌",
  "狗",
  "臭",
  "死",
  "傻",
  "逼",
  "鳩",
  "撚",
  "柒",
  "閪"
];
module.exports = {
  meta: {
    type: "suggestion",
    docs: {
      description: "查找是否出现脏词",
      category: "Stylistic Issues",
      recommended: false,
      url: ""
    },
    schema: []
  },
  create(context) {
    const sourceCode = context.getSourceCode().getText(); // 获取源码
    return {
      Program(node) {
        regs.forEach(regStr => {
          let reg = new RegExp(regStr, "ig");
          reg.test(sourceCode) &&
            context.report({
              node: node,
              message: "出现脏词 {{str}}",
              data: {
                str: regStr
              }
            });
        });
      }
    };
  }
};
