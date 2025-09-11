package io.github.heldev;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ToggleStretchingAction extends ToggleAction {

	@Override
	public boolean isSelected(@NotNull AnActionEvent event) {
		return getFacade(event).map(ElasticIndentationFacade::isStretchingEnabled).orElse(false);
	}

	@Override
	public void setSelected(@NotNull AnActionEvent event, boolean isEnabled) {
		if (isEnabled) {
			getFacade(event).ifPresent(ElasticIndentationFacade::enableStretching);
		} else {
			getFacade(event).ifPresent(ElasticIndentationFacade::disableStretching);
		}
	}

	public Optional<ElasticIndentationFacade> getFacade(AnActionEvent event) {
		return Optional.ofNullable( event.getProject())
                .map(project -> project.getService(ElasticIndentationFacade.class));
	}
}
