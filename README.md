# LeetCode 练习项目

这是一个用于练习LeetCode算法题目的Java项目。

## 📁 项目结构

```
src/
├── main/java/com/leetcode/
│   ├── array/              # 数组相关题目
│   │   └── q0026/         # 按题目编号分类
│   │       ├── RemoveDuplicates26.java
│   │       └── RemoveDuplicates26Test.java
│   ├── string/             # 字符串相关题目
│   ├── linkedlist/         # 链表相关题目
│   ├── tree/               # 树相关题目
│   ├── dp/                 # 动态规划题目
│   ├── binarysearch/       # 二分查找题目
│   └── utils/              # 工具类
│       ├── ListNode.java   # 链表节点
│       └── TreeNode.java   # 二叉树节点
└── test/java/              # 测试文件
```

## 🎯 命名规范

- **类名**：`题目英文名` + `题号`（如`RemoveDuplicates26`）
- **测试类**：`题目英文名` + `Test`
- **包名**：`com.leetcode.类型.q题号`

## 📝 题目模板

每个题目文件夹包含：
- `题目名.java` - 题目解法
- `题目名Test.java` - 测试用例
- 详细的题目描述和解题思路注释

## 🚀 运行测试

### 使用 Gradle
```bash
# 运行所有测试
./gradlew test
```

### 使用 javac
```bash
# 编译项目
rm -rf build/classes && mkdir -p build/classes
javac -d build/classes -cp "lib/*" -sourcepath src/main/java:src/test/java $(find src -name "*.java")
```

## 🛠️ IDE 配置

### IntelliJ IDEA
1. 直接打开项目根目录即可
2. IDE 会自动识别 Gradle 项目结构

### VS Code
1. 安装 "Java Extension Pack" 插件
2. 打开项目根目录
3. 如果遇到 JUnit 导入错误，请确保：
   - 项目中已存在 `.classpath` 和 `.project` 文件（已自动生成）
   - 重新加载项目（快捷键：Ctrl+Shift+P -> "Java: Clean Java Language Server Workspace"）

### 其他 IDE
- 项目已配置为标准 Java 项目，包含完整的 `.classpath` 和 `.project` 文件
- 确保 IDE 识别 `lib/` 目录下的 JUnit 依赖

## 📚 学习建议

1. **按类型练习**：先掌握一种数据结构的常见模式
2. **写测试用例**：每个解法都要有完整的测试覆盖
3. **记录思路**：在代码注释中记录解题思路和复杂度分析
4. **定期复习**：定期回顾已做过的题目

## 🔧 工具类使用

### ListNode（链表节点）
```java
// 从数组创建链表
int[] values = {1, 2, 3, 4, 5};
ListNode head = ListNode.fromArray(values);

// 转换为数组
int[] result = ListNode.toArray(head);
```

### TreeNode（二叉树节点）
```java
// 从数组创建二叉树
Integer[] values = {1, 2, 3, null, 4, 5};
TreeNode root = TreeNode.fromArray(values);

// 前序遍历
List<Integer> preorder = TreeNode.preorderTraversal(root);
```
