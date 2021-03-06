package com.github.atomicblom.nullplayerexception.client.gui;

import com.github.atomicblom.nullplayerexception.NullPlayerExceptionMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AlternativePlayerList extends GuiPlayerTabOverlay {
    public AlternativePlayerList(Minecraft mcIn, GuiIngame guiIngameIn) {
        super(mcIn, guiIngameIn);
    }

    @Override
    public String getPlayerName(NetworkPlayerInfo networkPlayerInfoIn) {

        String name = networkPlayerInfoIn.getGameProfile().getName();
        boolean isObfuscated = false;
        if (NullPlayerExceptionMod.corruptedPlayerNames.contains(name.toLowerCase())) {
            isObfuscated = true;
        }

        String displayName = super.getPlayerName(networkPlayerInfoIn);

        if (isObfuscated) {
            displayName = "§k" + displayName;
        }

        return displayName;
    }
}
