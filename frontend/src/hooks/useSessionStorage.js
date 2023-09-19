import { useState } from "react";

export default function useSessionStorage(key, transformValue = value => value) {

    const getValue = () => {
        const itemString = sessionStorage.getItem(key);
        const item = JSON.parse(itemString);
        return transformValue(item);
    }

    const [storedValue, setStoredValue] = useState(getValue());

    const saveValue = (value) => {
        if(value === "") {
            removeValue();
            return;
        }
        const transformedValue = transformValue(value);
        sessionStorage.setItem(key, JSON.stringify(transformedValue));
        setStoredValue(transformedValue);
    }

    const removeValue = () => {
        sessionStorage.removeItem(key);
        setStoredValue(undefined);
    }

    return {
        setValue: saveValue,
        value: storedValue,
        removeValue
    }
}

export function useToken() {
    const { setValue: setToken, value: token, removeValue: removeToken } = useSessionStorage("token");

    return {
        token,
        setToken,
        removeToken,
    };
}