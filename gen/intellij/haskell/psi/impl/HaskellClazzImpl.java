// This is a generated file. Not intended for manual editing.
package intellij.haskell.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import intellij.haskell.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaskellClazzImpl extends HaskellCompositeElementImpl implements HaskellClazz {

  public HaskellClazzImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitClazz(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HaskellQName> getQNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQName.class);
  }

  @Override
  @Nullable
  public HaskellTtype getTtype() {
    return PsiTreeUtil.getChildOfType(this, HaskellTtype.class);
  }

  @Override
  @NotNull
  public List<HaskellTtype1> getTtype1List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTtype1.class);
  }

  @Override
  @NotNull
  public List<HaskellTtype2> getTtype2List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTtype2.class);
  }

  @Override
  @NotNull
  public List<HaskellTypeSignature> getTypeSignatureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTypeSignature.class);
  }

}
