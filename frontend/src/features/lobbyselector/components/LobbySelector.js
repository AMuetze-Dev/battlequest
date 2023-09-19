import { useEffect } from "react";
import useLobbyLoading from "../hooks/useLobbyLoading";

export default function LobbySelector() {

    const { lobbies } = useLobbyLoading();
    console.log(lobbies);
    return (
        <div>
            {lobbies?.map((lobby, index) => (
                <div key={index}>CODE: {lobby.code}</div>
            ))}
        </div>
    )
}