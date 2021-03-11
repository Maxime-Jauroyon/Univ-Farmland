package com.ustudents.farmland.core.grid;

import com.ustudents.engine.core.json.annotation.JsonSerializable;
import com.ustudents.engine.graphic.Sprite;
import org.joml.Vector4f;

@JsonSerializable
public class Cell {
    @JsonSerializable
    public Sprite sprite;

    @JsonSerializable
    public Integer ownerId;

    @JsonSerializable
    public String itemId;

    // TODO: Change
    @JsonSerializable(necessary = false)
    public Vector4f viewRectangle;

    public Cell() {
        this.sprite = null;
        this.viewRectangle = null;
        this.ownerId = -1;
        this.itemId = null;
    }

    public Cell(Sprite sprite, Vector4f viewRectangle) {
        this.sprite = sprite;
        this.viewRectangle = viewRectangle;
        this.ownerId = -1;
        this.itemId = null;
    }

    public void setOwned(boolean owned, int ownerId) {
        this.ownerId = ownerId;
    }

    public void setItem(String item) {
        this.itemId = item;
    }

    public boolean isOwned() {
        return ownerId != -1;
    }

    public boolean isOwnedByCurrentPlayer() {
        return ownerId == 0;
    }
}
