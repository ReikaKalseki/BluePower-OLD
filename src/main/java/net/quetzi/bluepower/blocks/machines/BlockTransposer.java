/*
 * This file is part of Blue Power.
 *
 *     Blue Power is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Blue Power is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Blue Power.  If not, see <http://www.gnu.org/licenses/>
 *     
 *     @author Quetzi
 */

package net.quetzi.bluepower.blocks.machines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.quetzi.bluepower.blocks.BlockContainer6Sided;
import net.quetzi.bluepower.references.GuiIDs;
import net.quetzi.bluepower.references.Refs;
import net.quetzi.bluepower.tileentities.tier1.TileTransposer;

public class BlockTransposer extends BlockContainer6Sided {

    public BlockTransposer() {

        super(Material.rock);
        this.setBlockName(Refs.TRANSPOSER_NAME);
    }

    @Override
    protected Class<? extends TileEntity> getTileEntity() {

        return TileTransposer.class;
    }

    @Override
    public GuiIDs getGuiID() {

        return GuiIDs.INVALID;
    }

}