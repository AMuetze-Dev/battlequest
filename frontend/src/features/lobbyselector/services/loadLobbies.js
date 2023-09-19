import { API_USER_URL } from "../../../data/constants";

export async function loadLobbies() {
    try {
        const response = await fetch(`${API_USER_URL}/lobby`);
        if(!response.ok)
            throw new Error("Load Lobbies failed. Server response not okay");
        const data = await response.json();
        if(!data || data.error)
            throw new Error("Load Lobbies failed. Invalid response from server.");
        return data;
    }catch(error) {
        console.error("loadLobbies error: ", error);
        return undefined;
    }
}