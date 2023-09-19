import { API_USER_URL } from "../../../data/constants";

async function modifyNickname(id, nickname) {
    try {
      const response = await fetch(`${API_USER_URL}/player/${id}/nickname`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: nickname
      });
  
      if (!response.ok)
        throw new Error("Modify Nickname failed. Server response not okay.");
    } catch (error) {
      console.error("Modify Nickname error: ", error);
      return undefined;
    }
  }
  
  export { modifyNickname };