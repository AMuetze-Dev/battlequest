const primaryLight = "240,240,240";
const secondaryLight = "255,255,255";
const tertiaryLight = "0,178,103";
const textLight = "64,78,100";
const subtextLight = "128,143,159";

const primaryDark = "13,13,13";
const secondaryDark = "26,26,26";
const tertiaryDark = "221,82,1";
const textDark = "255,255,255";
const subtextDark = "87,87,87";

const defaultDark = !window.matchMedia("(prefers-color-scheme: dark)").matches;

const root = document.documentElement;
root.style.setProperty("--primary", defaultDark ? primaryDark : primaryLight);
root.style.setProperty("--secondary", defaultDark ? secondaryDark : secondaryLight);
root.style.setProperty("--tertiary", defaultDark ? tertiaryDark : tertiaryLight);
root.style.setProperty("--text", defaultDark ? textDark : textLight);
root.style.setProperty("--subtext", defaultDark ? subtextDark : subtextLight);

root.style.setProperty("--primary-color", "rgb(var(--primary))");
root.style.setProperty("--secondary-color", "rgb(var(--secondary))");
root.style.setProperty("--tertiary-color", "rgb(var(--tertiary))");
root.style.setProperty("--text-color", "rgb(var(--text))");
root.style.setProperty("--subtext-color", "rgb(var(--subtext))");