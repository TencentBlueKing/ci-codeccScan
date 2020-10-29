auto-correct
============
[![Build Status](https://travis-ci.org/node-modules/auto-correct.svg?branch=0.4.3)](https://travis-ci.org/node-modules/auto-correct)

auto correct for command line tools

make `install` match with:

```
install
nstall
nistall
istall
isntall
intall
intsall
insall
insatll
instll
instlal
instal
install
```

## install

```
npm install auto-correct
```

## Usage

```
var match = require('auto-correct');

match('insall', 'install'); // true
```
