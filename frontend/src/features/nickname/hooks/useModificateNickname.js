import { useEffect, useState } from "react";
import { loadNickname } from "../services/reload";
import { modifyNickname } from "../services/modifyNickname";
import { useToken } from "../../../hooks/useSessionStorage";

export default function useNicknameForm(transformValue = value => value) {

    const [nickname, setNickname] = useState("");
    const { token } = useToken();

    useEffect(() => { getNickname() }, []);

    const getNickname = async () => {
        const item = await loadNickname(token);
        const transformedItem = transformValue(item);
        setNickname(transformedItem);
    }

    const storeNickname = (event) => {
        const storedValue = transformValue(event.target.value);
        setNickname(storedValue);
    }

    const updateGlobalNickname = () => {
        console.log("NICKNAME:", nickname)
        modifyNickname(token, nickname);
    }

    return { nickname, setNickname: storeNickname, updateGlobalNickname, getNickname };
}