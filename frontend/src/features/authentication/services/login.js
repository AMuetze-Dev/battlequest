import { validateCredentials } from "../../../services/validation";
import { API_USER_URL } from "../../../data/constants";

async function login(credentials) {
    try {
        const { isValidated, response: test } = await validateCredentials(credentials);
        if (!isValidated)
            throw new Error(test);

        const response = await fetch(`${API_USER_URL}/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credentials)
        })

        if (!response.ok)
            throw new Error("Login failed. Server response not okay.");
        const data = await response.json();
        if (!data || data.error)
            throw new Error("Login failed. Invalid response from server.");
        return data;
    } catch (error) {
        console.error("Login error:", error);
        return undefined;
    }
}

export { login };