import { useEffect, useState } from "react";
import { loadLobbies } from "../services/loadLobbies";

export default function useLobbyLoading(transformValue = value => value) {

    useEffect(() => {load()}, []);

    const load = async () => {
        const data = await loadLobbies();
        const transformedValue = transformValue(data);
        setLobbies(transformedValue);
    }

    const [lobbies, setLobbies] = useState([{}]);

    return {
        lobbies,
        reload: load
    }
}