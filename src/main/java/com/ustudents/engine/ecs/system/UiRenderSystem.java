package com.ustudents.engine.ecs.system;

import com.ustudents.engine.ecs.Entity;
import com.ustudents.engine.ecs.Registry;
import com.ustudents.engine.ecs.component.graphics.UiRendererComponent;
import com.ustudents.engine.graphic.Spritebatch;
import com.ustudents.engine.scene.SceneManager;

public class UiRenderSystem extends RenderSystem {
    public UiRenderSystem(Registry registry) {
        super(registry);

        requireComponent(UiRendererComponent.class);
    }

    @Override
    public void render() {
        if (getEntities().size() == 0) {
            return;
        }

        Spritebatch spritebatch = SceneManager.getScene().getSpritebatch();

        spritebatch.begin(SceneManager.getScene().getUiCamera());

        for (Entity entity : getEntities()) {
            renderElement(spritebatch, entity, UiRendererComponent.class);
        }

        spritebatch.end();
    }
}
