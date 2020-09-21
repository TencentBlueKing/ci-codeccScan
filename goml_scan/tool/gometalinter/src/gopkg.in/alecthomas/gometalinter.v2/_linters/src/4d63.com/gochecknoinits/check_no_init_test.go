package main

import (
	"fmt"
	"testing"
)

func TestCheckNoInits(t *testing.T) {
	cases := []struct {
		path         string
		includeTests bool
		wantMessages []string
	}{
		{
			path:         "testdata/0",
			wantMessages: nil,
		},
		{
			path:         "testdata/0/code.go",
			wantMessages: nil,
		},
		{
			path:         "testdata/1",
			wantMessages: nil,
		},
		{
			path:         "testdata/1",
			includeTests: true,
			wantMessages: nil,
		},
		{
			path:         "testdata/2",
			wantMessages: nil,
		},
		{
			path: "testdata/3",
			wantMessages: []string{
				"testdata/3/code_0.go:3 init function",
			},
		},
		{
			path:         "testdata/3",
			includeTests: true,
			wantMessages: []string{
				"testdata/3/code_0.go:3 init function",
				"testdata/3/code_0_test.go:3 init function",
			},
		},
		{
			path: "testdata/4",
			wantMessages: []string{
				"testdata/4/code.go:5 init function",
			},
		},
		{
			path: "testdata/4/...",
			wantMessages: []string{
				"testdata/4/code.go:5 init function",
				"testdata/4/subpkg/code_0.go:3 init function",
			},
		},
		{
			path: "testdata/5",
			wantMessages: []string{
				"testdata/5/code_0.go:3 init function",
				"testdata/5/code_1.go:17 init function",
			},
		},
		{
			path: "testdata/5/code_0.go",
			wantMessages: []string{
				"testdata/5/code_0.go:3 init function",
			},
		},
		{
			path:         ".",
			wantMessages: nil,
		},
		{
			path: "./...",
			wantMessages: []string{
				"testdata/3/code_0.go:3 init function",
				"testdata/4/code.go:5 init function",
				"testdata/4/subpkg/code_0.go:3 init function",
				"testdata/5/code_0.go:3 init function",
				"testdata/5/code_1.go:17 init function",
			},
		},
	}

	for _, c := range cases {
		caseName := fmt.Sprintf("%s include tests: %t", c.path, c.includeTests)
		t.Run(caseName, func(t *testing.T) {
			messages, err := checkNoInits(c.path, c.includeTests)
			if err != nil {
				t.Fatalf("got error %#v", err)
			}
			if !stringSlicesEqual(messages, c.wantMessages) {
				t.Errorf("got %#v, want %#v", messages, c.wantMessages)
			}
		})
	}
}

func stringSlicesEqual(s1, s2 []string) bool {
	diff := map[string]int{}
	for _, s := range s1 {
		diff[s]++
	}
	for _, s := range s2 {
		diff[s]--
		if diff[s] == 0 {
			delete(diff, s)
		}
	}
	return len(diff) == 0
}
