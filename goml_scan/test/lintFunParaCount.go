package main

import "fmt"

type Cat struct {
	Name string
}

func (cat *Cat) Run(a, b, c, d, e int) {
	fmt.Printf("cat %s is running\n", cat.name)
}
