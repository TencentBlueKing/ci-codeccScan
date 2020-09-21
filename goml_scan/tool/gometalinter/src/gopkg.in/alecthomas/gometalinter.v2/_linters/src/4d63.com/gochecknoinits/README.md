# gochecknoinits

[![Build Status](https://img.shields.io/travis/leighmcculloch/gochecknoinits.svg)](https://travis-ci.org/leighmcculloch/gochecknoinits)
[![Codecov](https://img.shields.io/codecov/c/github/leighmcculloch/gochecknoinits.svg)](https://codecov.io/gh/leighmcculloch/gochecknoinits)
[![Go Report Card](https://goreportcard.com/badge/github.com/leighmcculloch/gochecknoinits)](https://goreportcard.com/report/github.com/leighmcculloch/gochecknoinits)

Check that no inits functions are present in Go code.

## Why

Init functions cause an import to have a side effects, and side effects are hard to test, reduce readability and increase the complexity of code.

https://peter.bourgon.org/blog/2017/06/09/theory-of-modern-go.html
https://twitter.com/davecheney/status/871939730761547776

## Install

```
go get 4d63.com/gochecknoinits
```

## Usage

```
gochecknoinits
```

```
gochecknoinits ./...
```

```
gochecknoinits [path] [path] [path] [etc]
```

Add `-t` to include tests.

```
gochecknoinits -t [path]
```

Note: Paths are only inspected recursively if the Go `/...` recursive path suffix is appended to the path.
