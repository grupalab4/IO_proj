Chciałbym, aby podstrony były przygotowane w następujący sposób:
- `html/nazwa` podstrona
  - `index.html` kod html podstrony
  - `nazwa.js` skrypty
- `html/css/nazwa.css`  style

skrypty dodajemy na końcu `<body>`, przy pomocy: `<script src='../js/tools.js'></script>`
jeżeli jesteście sami pisać skrypty JavaScript, to będzie to bardzo pomocne, jeśli jednak potrzebna będzie pomoc to proście o pomoc na kanale [#fe](https://discord.com/channels/1031948492635119746/1045725601434193960) lub prywatnie Kukininja#7162.

style dodajemy w nagłówku `<head>` przy pomocy: `<link href="../css/main.css" rel="stylesheet" />` (jak będzie przygotowany serwer do serwowania strony, to odpowiednio zmienimy linki),
nie piszemy stylów w formacie `inline` czyli:
```html
<div style='display: flex'> nic </div> <!-- dont do that! -->
```

Do pisania htmla zalecam [VSCodium](https://vscodium.com/) lub [VSCode](https://vscodium.com/) z dodatkami:
 - [HTML CSS support](https://open-vsx.org/extension/ecmel/vscode-html-css)
 - [HTML snippets](https://open-vsx.org/extension/abusaidm/html-snippets)
 - [IntelliSense for CSS class names in HTML](https://open-vsx.org/extension/Zignd/html-css-class-completion)
Linki są do VSCodium, raczej bez problemu znajdziecie je w Marketplace VSCode.

Przed każdym commitem formatujcie kod plików w których dokonaliście zmian `ctrl + shift + i` lub `ctrl + shift + p > Format Document`, poprawia to czytelność diffów.
