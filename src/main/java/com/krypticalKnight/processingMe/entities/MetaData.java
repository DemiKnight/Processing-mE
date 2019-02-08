package com.krypticalKnight.processingMe.entities;

import processing.data.JSONArray;
import processing.data.JSONObject;

import javax.lang.model.type.TypeKind;

@SuppressWarnings("JavadocReference")
public class MetaData
{
    protected final Entity targetEntity;

    private JSONObject rawInformation;

    public MetaData(Entity specificEntity)
    {
        this.targetEntity = specificEntity;

        this.rawInformation = new JSONObject();
    }

    /**
     * @brief
     *
     * @param[in] metaKey
     * @param <T>
     * @return The value tied to the given key,
     */
    public <T> T getMetaValueUnsafe(String metaKey)
    {
        return (T) rawInformation.get(metaKey);
    }

    /**
     * @brief Return the meta data value, tied to the relative key. Will check for it's existence beforehand.
     *
     * @details
     * Check {@link MetaData.rawInformation rawInformation} for the given {@p metaKey}, if found will return the given value.
     * If the key does not exist, will return null.
     *
     * This function relies on {@link MetaData.getMetaValueUnsafe getMetaValueUnsafe()}, which actually looks up the value,
     * however does not check if it exists.
     *
     * @param[in] metaKey Key to requested Value
     * @param <T> The expected type of the value.
     * @return The value for tied to the key. Null if not found.
     */
    public <T> T getMetaValue(String metaKey)
    {
        if (rawInformation.hasKey(metaKey))
        {
            return getMetaValueUnsafe(metaKey);
        }

        //Has not been found
        return null;
    }

    public JSONObject getRawInformation()
    {
        return this.rawInformation;
    }

    public <T> void addInformation(String newKey, T data)
    {
        this.rawInformation.put(newKey, data);
    }

//    public <T> void  setInformation(String newKey, TypeKind TYPE, T data)
//    {
//        switch (TYPE)
//        {
//            case BOOLEAN:
//                rawInformation.setBoolean(newKey, (boolean) data);
//                break;
//            case INT:
//                rawInformation.setInt(newKey, (int) data);
//                break;
//            case LONG:
//                rawInformation.setLong(newKey, (long) data);
//                break;
//            case FLOAT:
//                rawInformation.setFloat(newKey, (float) data);
//                break;
//            case DOUBLE:
//                rawInformation.setDouble(newKey, (double) data);
//                break;
//            case ARRAY:
//                rawInformation.setJSONArray(newKey, (JSONArray) data);
//                break;
//        }
//    }

    public Entity getTargetEntity()
    {
        return this.targetEntity;
    }

}
