#!/usr/bin/env bash

# 简化的Gradle Wrapper脚本
GRADLE_VERSION="8.5"

echo "正在准备Gradle环境..."
echo "使用Gradle版本: $GRADLE_VERSION"

# 创建临时Gradle目录
TMP_DIR="${HOME}/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin"
mkdir -p "$TMP_DIR"

# 检查Java版本
echo "Java版本："
java -version

# 如果是测试命令，直接运行Java测试
if [ "$1" = "test" ]; then
    echo "执行测试..."
    # 编译并运行测试
    javac -d build/classes -cp "build/classes:lib/*" -sourcepath src/main/java:src/test/java $(find src/test -name "*Test.java")
    java -cp "build/classes:lib/*:lib/junit-4.13.2.jar" org.junit.runner.JUnitCore $(find src/test -name "*Test.java" | sed 's/src\/test\/java\///' | sed 's/\//\./g' | sed 's/\.java$//')
else
    echo "未知命令。使用 './gradlew test' 运行测试。"
fi