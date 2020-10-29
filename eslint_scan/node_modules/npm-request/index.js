/**!
 * npm-request - index.js
 *
 * Copyright(c) cnpmjs.org and other contributors.
 * MIT Licensed
 *
 * Authors:
 *  dead_horse <dead_horse@qq.com> (http://deadhorse.me)
 */

'use strict';

/**
 * Module dependencies.
 */

var urllib = require('urllib');
var fs = require('fs');
var path = require('path');

function parseConfig(configFile) {
  var cookie = '';
  var userconfig = {};
  try {
    var cookieStart = false;
    var tmpCookie = [];
    var cfgs = fs.readFileSync(configFile, 'utf8').split('\n');
    for (var i = 0; i < cfgs.length; i++) {
      var cfg = cfgs[i];
      if (cfg === '[_token]') {
        cookieStart = true;
        continue;
      }

      if (!cookieStart) {
        cfg = cfg.match(/(.*?)\s+=\s+(.*)/);
        if (!cfg) {
          continue;
        }
        userconfig[cfg[1]] = cfg[2];
      } else {
        tmpCookie.push(cfg);
      }
    }
    cookie = tmpCookie.join(';');
  } catch (err) {
    //ignore
  }
  return {
    cookie: cookie,
    userconfig: userconfig
  };
}

var root;
if (process.platform === 'win32') {
  root = process.env.USERPROFILE || process.env.APPDATA || process.env.TMP || process.env.TEMP;
} else {
  root = process.env.HOME || process.env.TMPDIR || '/tmp';
}

var DEFAULT_NPM_OPTIONS = {
  registry: 'https://registry.npmjs.org',
  configFile: path.join(root, '.npmrc')
};

module.exports = function (request, options, callback) {
  if (typeof options === 'function') {
    callback = options;
    options = {};
  }
  options = options || {};
  for (var key in DEFAULT_NPM_OPTIONS) {
    options[key] = options[key] || DEFAULT_NPM_OPTIONS[key];
  }

  var reqOptions = {
    method: request.method,
    headers: {},
    data: request.data,
    timeout: request.timeout || 30000,
    gzip: true
  };

  var npmConfigInfo = parseConfig(options.configFile);

  if (npmConfigInfo.cookie) {
    reqOptions.headers.Cookie = npmConfigInfo.cookie;
  }
  if (npmConfigInfo.userconfig._auth) {
    reqOptions.headers.authorization = 'Basic ' + npmConfigInfo.userconfig._auth;
  }
  if (reqOptions.data) {
    reqOptions.headers['Content-Length'] = JSON.stringify(reqOptions.data).length;
    reqOptions.headers['Content-Type'] = 'application/json';
  }

  var host = options.registry.replace(/\/$/, '');
  request.path.replace(/^\//, '');
  var url = host + '/' + request.path;
  urllib.request(url, reqOptions, function (err, data, res) {
    var parsed = {};
    if (err) {
      return callback(err, parsed, data, res);
    }
    try {
      parsed = JSON.parse(data.toString());
    } catch (err) {
      //ignore
    }
    callback(err, parsed, data, res);
  });
};
