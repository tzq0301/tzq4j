package cn.tzq0301.program;

import java.util.Optional;

public final class ProgramUtils {
    private ProgramUtils() {
    }

    /**
     * 获取当前行号
     *
     * <ul>
     *     <li>如果编译时没有保留调试信息（例如使用了 javac 命令的 -g:none 选项），则无法在运行时获取行号信息，此时返回 {@code Optional.empty()}</li>
     *     <li>在 Lambda 表达式中可能无法正确地获取当前行号（因为 Lambda 表达式是动态生成的匿名类的实例，而这个实例的行号通常是 Lambda 表达式生成代码的行号，而不是包含 Lambda 表达式的代码行号）</li>
     * </ul>
     *
     * @return 当前行号（如果可以获取到）
     */
    public static Optional<Integer> getCurrentLineNumber() {
        return StackWalker.getInstance()
                .walk(stackFrameStream -> stackFrameStream.skip(1).findFirst())
                .map(StackWalker.StackFrame::getLineNumber);
    }
}
