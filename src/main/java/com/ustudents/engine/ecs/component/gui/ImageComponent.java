package com.ustudents.engine.ecs.component.gui;

import com.ustudents.engine.ecs.component.graphics.TextureComponent;
import com.ustudents.engine.graphic.imgui.annotation.Viewable;

public class ImageComponent extends GuiComponent {
    @Viewable
    public TextureComponent texture;

    public ImageComponent(TextureComponent texture) {

    }
}
