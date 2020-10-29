/*!
 * auto-correct - index.js
 * Copyright(c) 2014 dead_horse <dead_horse@qq.com>
 * MIT Licensed
 */

'use strict';

/**
 * Module dependencies.
 */

/**
 * auto correct
 *  install
 *  nstall
 *  nistall
 *  istall
 *  isntall
 *  intall
 *  intsall
 *  insall
 *  insatll
 *  instll
 *  instlal
 *  instal
 *  install
 *
 * =>
 *
 *  install
 *
 * @param {[type]} input [description]
 * @param {[type]} word [description]
 * @return {[type]} [description]
 */
module.exports = function (input, word) {
  return !!genMap(word)[input];
};

function genMap(word) {
  var map = {};
  map[word] = true;

  word = word.split('');

  for (var i = 0; i < word.length; i++) {
    var tmp = word.slice();
    tmp.splice(i, 1);
    map[tmp.join('')] = true;

    if (i === word.length) {
      break;
    }
    tmp = word.slice();
    tmp[i] = word[i + 1];
    tmp[i + 1] = word[i];
    map[tmp.join('')] = true;
  }
  return map;
}
