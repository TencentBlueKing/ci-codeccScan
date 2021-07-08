package main

import "fmt"

var a int = 20

func main() {

	var a int = 10
	var b int = 20
	var c int = 0

	fmt.Printf("main()啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦 a = %d\n", a)
	c = sum(a, b)
	fmt.Printf("main()22222222222222222222222222222222222222222222222222222222222222222222222222 c = %d\n", c)
}

func sum111111111111111111111111111111111(a, b int) int {
	fmt.Printf("sum() 函数中 a = %d\n", a)
	fmt.Printf("sum() 函数中 b = %d\n", b)
	return a + b
}
