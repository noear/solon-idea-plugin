package org.noear.solon.idea.plugin.common.util;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PsiCustomUtil {

    @Nullable
    public static VirtualFile findFileUnderRootInModule(Module module, String targetFileName) {
        VirtualFile[] contentRoots = ModuleRootManager.getInstance(module).getContentRoots();
        for (VirtualFile contentRoot : contentRoots) {
            VirtualFile childFile = findFileUnderRootInModule(contentRoot, targetFileName);
            if (childFile != null) {
                return childFile;
            }
        }
        return null;
    }

    @Nullable
    public static VirtualFile findFileUnderRootInModule(@NotNull VirtualFile contentRoot,
                                                        String targetFileName) {
        VirtualFile childFile = contentRoot.findChild(targetFileName);
        if (childFile != null) {
            return childFile;
        }
        return null;
    }

}
