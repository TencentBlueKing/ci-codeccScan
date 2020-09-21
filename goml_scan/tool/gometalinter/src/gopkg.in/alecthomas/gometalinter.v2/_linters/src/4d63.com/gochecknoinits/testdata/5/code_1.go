package code

var myVar = 0

type S struct{}

func (s S) init(arg string) bool {
	yourVar := true
	return yourVar
}

func function() {
	init := func() {}
	init()
}

func init() {
}
