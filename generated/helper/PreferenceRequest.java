//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.2
//
// <auto-generated>
//
// Generated from file `Helper.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package helper;

public class PreferenceRequest implements java.lang.Cloneable,
                                          java.io.Serializable
{
    public String username;

    public int weather;

    public String value;

    public PreferenceRequest()
    {
        this.username = "";
        this.value = "";
    }

    public PreferenceRequest(String username, int weather, String value)
    {
        this.username = username;
        this.weather = weather;
        this.value = value;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PreferenceRequest r = null;
        if(rhs instanceof PreferenceRequest)
        {
            r = (PreferenceRequest)rhs;
        }

        if(r != null)
        {
            if(this.username != r.username)
            {
                if(this.username == null || r.username == null || !this.username.equals(r.username))
                {
                    return false;
                }
            }
            if(this.weather != r.weather)
            {
                return false;
            }
            if(this.value != r.value)
            {
                if(this.value == null || r.value == null || !this.value.equals(r.value))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::helper::PreferenceRequest");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, username);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, weather);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, value);
        return h_;
    }

    public PreferenceRequest clone()
    {
        PreferenceRequest c = null;
        try
        {
            c = (PreferenceRequest)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.username);
        ostr.writeInt(this.weather);
        ostr.writeString(this.value);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.username = istr.readString();
        this.weather = istr.readInt();
        this.value = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, PreferenceRequest v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public PreferenceRequest ice_read(com.zeroc.Ice.InputStream istr)
    {
        PreferenceRequest v = new PreferenceRequest();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<PreferenceRequest> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, PreferenceRequest v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<PreferenceRequest> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(PreferenceRequest.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final PreferenceRequest _nullMarshalValue = new PreferenceRequest();

    /** @hidden */
    public static final long serialVersionUID = -1419444699L;
}
