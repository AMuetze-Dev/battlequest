import { API_USER_URL } from "../../../data/constants";

async function loadNickname(id) {
    try {
        const response = await fetch(`${API_USER_URL}/player/${id}/nickname`);
        if (!response.ok)
            throw new Error("Load Nickname failed. Server response not okay.");
        const data = await response.text();
        if (!data || data.error)
            throw new Error("Load Nickname failed. Invalid response from server.");
        return data;
    } catch (error) {
        console.error("Load Nickname error: ", error);
        return undefined;
    }
}

export { loadNickname };