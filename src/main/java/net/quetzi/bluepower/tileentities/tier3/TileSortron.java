package net.quetzi.bluepower.tileentities.tier3;

import cpw.mods.fml.common.Optional;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.quetzi.bluepower.references.Dependencies;
import net.quetzi.bluepower.tileentities.TileMachineBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Optional.Interface(iface = "dan200.computercraft.api.peripheral.IPeripheral", modid = Dependencies.COMPUTER_CRAFT)
public class TileSortron extends TileMachineBase implements IPeripheral{

    private Set<IComputerAccess> connectedComputers = new HashSet<IComputerAccess>();
    private List<Byte>           acceptedColors     = new ArrayList<Byte>();
    private List<ItemStack>      acceptedStacks     = new ArrayList<ItemStack>();

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public String getType() {

        return "BluePower.Sortron";
    }

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public String[] getMethodNames() {

        return new String[] { "addAcceptedCol", "removeAcceptedCol", "getAcceptedCols", "addAcceptedItem", "removeAcceptedItem", "getAcceptedItems",
                "getNumSlots", "pullFromSlot", "getSlotContents" };
    }

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws Exception {

        switch (method) {
            case 0:
                if (arguments.length > 0) {
                    if (arguments[0] instanceof Double) {
                        byte color = ((Double) arguments[0]).byteValue();
                        if (color >= 0 && color < 16) {
                            if (!acceptedColors.contains(color)) {
                                acceptedColors.add(color);
                                return new Boolean[] { true };
                            } else {
                                return new Boolean[] { false };
                            }
                        }
                        throw new IllegalArgumentException("Color values should be greater than or equal to 0 and smaller than 16");
                    } else if (arguments[0] instanceof String) {
                        String argument = (String) arguments[0];
                        for (byte color = 0; color < ItemDye.field_150923_a.length; color++) {
                            String colorName = ItemDye.field_150923_a[color];
                            if (colorName.equals(argument)) {
                                if (!acceptedColors.contains(color)) {
                                    acceptedColors.add(color);
                                    return new Boolean[] { true };
                                } else {
                                    return new Boolean[] { false };
                                }
                            }
                        }
                        throw new IllegalArgumentException("Given String is not a color");
                    }
                }
                throw new IllegalArgumentException("No expected argument was given");
            case 1:
                if (arguments.length > 0) {
                    if (arguments[0] instanceof Double) {
                        byte color = ((Double) arguments[0]).byteValue();
                        if (color >= 0 && color < 16) {
                            if (acceptedColors.contains(color)) {
                                acceptedColors.remove(color);
                                return new Boolean[] { true };
                            } else {
                                return new Boolean[] { false };
                            }
                        }
                        throw new IllegalArgumentException("Color values should be greater than or equal to 0 and smaller than 16");
                    } else if (arguments[0] instanceof String) {
                        String argument = (String) arguments[0];
                        for (byte color = 0; color < ItemDye.field_150923_a.length; color++) {
                            String colorName = ItemDye.field_150923_a[color];
                            if (colorName.equals(argument)) {
                                if (acceptedColors.contains(color)) {
                                    acceptedColors.remove(color);
                                    return new Boolean[] { true };
                                } else {
                                    return new Boolean[] { false };
                                }
                            }
                        }
                        throw new IllegalArgumentException("Given String is not a color");
                    }
                }
                throw new IllegalArgumentException("No expected argument was given");
            case 2:
                Byte[] arr = new Byte[acceptedColors.size()];
                for (int i = 0; i < acceptedColors.size(); i++) {
                    arr[i] = acceptedColors.get(i);
                }
                return arr;
            case 3:
                if (arguments.length > 0 && arguments[0] instanceof String) {
                    String unlocalizedName = ((String) arguments[0]);
                    Item item = (Item) Item.itemRegistry.getObject(unlocalizedName);
                    if (item != null) {
                        ItemStack stack;
                        if (arguments.length > 1 && arguments[1] instanceof Double) {
                            int meta = ((Double)arguments[1]).intValue();
                            if (meta >= 0) {
                                stack = new ItemStack(item, 1, meta);
                            } else {
                                throw new IllegalArgumentException("Metadata must be greater than or equal to 0");
                            }
                        } else {
                            stack = new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE);
                        }
                        if (!acceptedStacks.contains(stack)) {
                            acceptedStacks.add(stack);
                            return new Boolean[] { true };
                        }
                        return new Boolean[] { false };
                    }
                    throw new IllegalArgumentException("Item not found");
                }
                throw new IllegalArgumentException("No expected argument was given");
            case 4:
                if (arguments.length > 0 && arguments[0] instanceof String) {
                    String unlocalizedName = ((String) arguments[0]);
                    Item item = (Item) Item.itemRegistry.getObject(unlocalizedName);
                    if (item != null) {
                        ItemStack stack;
                        if (arguments.length > 1 && arguments[1] instanceof Double) {
                            int meta = ((Double)arguments[1]).intValue();
                            if (meta >= 0) {
                                stack = new ItemStack(item, 1, meta);
                            } else {
                                throw new IllegalArgumentException("Metadata must be greater than or equal to 0");
                            }
                        } else {
                            stack = new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE);
                        }
                        if (acceptedStacks.contains(stack)) {
                            acceptedStacks.remove(stack);
                            return new Boolean[] { true };
                        }
                        return new Boolean[] { false };
                    }
                    throw new IllegalArgumentException("Item not found");
                }
                throw new IllegalArgumentException("No expected argument was given");
            case 5:
                List<Object> list = new ArrayList<Object>();
                for (ItemStack stack : acceptedStacks) {
                    list.add(getStringFromStack(stack));
                }
                return list.toArray();
        }
        return new Object[0];
    }

    public static String getStringFromStack(ItemStack stack) {
        if (stack != null) {
            String string = Item.itemRegistry.getNameForObject(stack.getItem());
            if (stack.getItemDamage() != OreDictionary.WILDCARD_VALUE) {
                string += " " + stack.getItemDamage();
            }
            return string;
        }
        return null;
    }

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public void attach(IComputerAccess computer) {

        connectedComputers.add(computer);
    }

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public void detach(IComputerAccess computer) {

        connectedComputers.remove(computer);
    }

    @Override
    @Optional.Method(modid = Dependencies.COMPUTER_CRAFT)
    public boolean equals(IPeripheral other) {

        return other.getType().equals(this.getType());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {

        super.readFromNBT(compound);
        for (int i = 0; i < acceptedColors.size(); i++) {
            compound.setByte("acceptedCol" + i, acceptedColors.get(i));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);
        int compoundPos = 0;
        while (compound.hasKey("acceptedCol" + compoundPos)) {
            acceptedColors.add(compound.getByte("acceptedCol" + compoundPos));
            compoundPos++;
        }
    }
}
