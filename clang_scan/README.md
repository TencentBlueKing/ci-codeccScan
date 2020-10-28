## CLANGSTATICANALYZER工具

Clang静态检查工具是Clang编译器下的一款代码检查工具，可以通过推理代码的语义，在项目编译的过程中扫描出项目中存在的bug，例如空指针、API错误使用、无效代码、安全问题等。目前支持84种问题类型。

基于开源工具 [Clang Static Analyzer](https://clang-analyzer.llvm.org/)，可对Objective-C项目检查潜在的代码bug

版本：clang+llvm-8.0

checkers.json--规则集，包含84条工具版本所支持的检查规则，详细请查看 [Clang Available Checkers](http://clang.llvm.org/docs/analyzer/checkers.html) 。
