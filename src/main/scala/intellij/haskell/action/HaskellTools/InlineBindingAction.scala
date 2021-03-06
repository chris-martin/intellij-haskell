package intellij.haskell.action.HaskellTools

import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent}
import com.intellij.openapi.vfs.VfsUtil
import intellij.haskell.action.{ActionContext, ActionUtil}
import intellij.haskell.external.component.HaskellToolComponent
import intellij.haskell.psi.HaskellPsiUtil
import intellij.haskell.util.HaskellFileUtil

class InlineBindingAction extends AnAction {
  override def actionPerformed(actionEvent: AnActionEvent): Unit = {
    val project = actionEvent.getProject

    HaskellToolComponent.checkResolverForHaskellToolsAction(project, actionEvent, (actionEvent) => {
      ActionUtil.findActionContext(actionEvent).foreach {
        case ActionContext(psiFile, _, _, selectionModel) =>
          HaskellFileUtil.saveFile(psiFile)

          for {
            moduleName <- HaskellPsiUtil.findModuleName(psiFile)
            selectionModel <- selectionModel
          } yield {
            HaskellToolComponent.inlineBinding(project, moduleName, selectionModel)
            VfsUtil.markDirtyAndRefresh(true, true, true, HaskellFileUtil.findVirtualFile(psiFile))
          }
      }
    })
  }
}
