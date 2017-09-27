package com.example.viet.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class meta implements Parcelable
{
    private String name;

    public meta(String name)
    {
        update(name);
    }

    public void update(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        String str = "";
        str += name;
        return str;
    }

    /** Describe the contents in the parcel
     * interface forces implementation
     */
    public int describeContents()
    {
        return 0;
    }

    /* write data to the parcel */
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(name);
    }


    public static final Parcelable.Creator<meta> CREATOR = new Parcelable.Creator<meta>()
    {
        /*
            Methods required by the protocol
        */
        public meta createFromParcel(Parcel in)
        {
            /* Private constructor */
            return new meta(in);
        }

        public meta[] newArray(int size)
        {
            return new meta[size];
        }
    };


    /** private Constructor
     */
    private meta(Parcel in)
    {
        name = in.readString();
    }
}
