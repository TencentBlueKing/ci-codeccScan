1、如何打包docker镜像：
    docker build -t scan:temp -f ./docker/Dockerfile.manual .
2、如何推送docker镜像：
    docker tag scan:temp 镜像仓库路径
    docker push 镜像仓库路径

