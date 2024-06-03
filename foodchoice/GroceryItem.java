package com.example.foodchoice;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GroceryItem implements Parcelable {
    private int quantity;
    private String itemName;

    public GroceryItem(int quantity, String itemName) {
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String toString() {
        return quantity + ": " + itemName;
    }

    protected GroceryItem(Parcel in) {
        quantity = in.readInt();
        itemName = in.readString();
    }

    public static final Parcelable.Creator<GroceryItem> CREATOR = new Parcelable.Creator<GroceryItem>() {
        @Override
        public GroceryItem createFromParcel(Parcel in) {
            return new GroceryItem(in);
        }

        @Override
        public GroceryItem[] newArray(int size) {
            return new GroceryItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(quantity);
        dest.writeString(itemName);

    }
}
