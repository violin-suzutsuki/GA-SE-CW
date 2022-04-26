# GA Software Engineering Coursework

[![LICENSE](https://img.shields.io/github/license/violin-suzutsuki/SET08103.svg)](https://github.com/violin-suzutsuki/SET08103/blob/main/LICENSE)
[![Releases](https://img.shields.io/github/release/violin-suzutsuki/SET08103.svg)](#)
![Codebase Size](https://img.shields.io/github/languages/code-size/violin-suzutsuki/SET08103)
[![codecov](https://codecov.io/gh/violin-suzutsuki/GA-SE-CW/branch/main/graph/badge.svg?token=Zah5mYcSbt)](https://codecov.io/gh/violin-suzutsuki/GA-SE-CW)

#### Main Branch

![workflow](https://img.shields.io/github/workflow/status/violin-suzutsuki/SET08103/A%20workflow%20for%20coursework/master)<br>
![commit](https://img.shields.io/github/last-commit/violin-suzutsuki/SET08103/master)

#### Release Branch

![workflow](https://img.shields.io/github/workflow/status/violin-suzutsuki/SET08103/A%20workflow%20for%20coursework/release)<br>
![commit](https://img.shields.io/github/last-commit/violin-suzutsuki/SET08103/release)

#### Development Branch

![workflow](https://img.shields.io/github/workflow/status/violin-suzutsuki/SET08103/A%20workflow%20for%20coursework/develop)<br>
![commit](https://img.shields.io/github/last-commit/violin-suzutsuki/SET08103/develop)

#### Issues

![open](https://img.shields.io/github/issues/violin-suzutsuki/SET08103)
![closed](https://img.shields.io/github/issues-closed/violin-suzutsuki/SET08103)

#### Project Requirements
> 32 requirements of 32 have been implemented, which is 100%.

| ID  | Name | Met | Screenshot |
|-----|------|-----|------------|
| 1   | All the countries in the world organised by largest population to smallest. | Yes | Blank |
| 2   | All the countries in a continent organised by largest population to smallest. | Yes | Blank |
| 3   | All the countries in a region organised by largest population to smallest. | Yes | Blank |
| 4   | The top `N` populated countries in the world where `N` is provided by the user. | Yes | Blank |
| 5   | The top `N` populated countries in a continent where `N` is provided by the user. | Yes | Blank |
| 6   | The top `N` populated countries in a region where `N` is provided by the user. | Yes | Blank |
| 7   | All the cities in the world organised by largest population to smallest. | Yes | Blank |
| 8   | All the cities in a continent organised by largest population to smallest. | Yes | Blank |
| 9   | All the cities in a region organised by largest population to smallest. | Yes | Blank |
| 10  | All the cities in a country organised by largest population to smallest. | Yes | Blank |
| 11   | All the cities in a district organised by largest population to smallest. | Yes | Blank |
| 12   | The top `N` populated cities in the world where `N` is provided by the user. | Yes | Blank |
| 13   | The top `N` populated cities in a continent where `N` is provided by the user. | Yes | Blank |
| 14   | The top `N` populated cities in a region where `N` is provided by the user. | Yes | Blank |
| 15   | The top `N` populated cities in a country where `N` is provided by the user. | Yes | Blank |
| 16   | The top `N` populated cities in a district where `N` is provided by the user. | Yes | Blank |
| 17   | All the capital cities in the world organised by largest population to smallest. | Yes | Blank |
| 18  | All the capital cities in a continent organised by largest population to smallest. | Yes | Blank |
| 19   | All the capital cities in a region organised by largest to smallest. | Yes | Blank |
| 20   | The top `N` populated capital cities in the world where `N` is provided by the user. | Yes | Blank |
| 21   | The top `N` populated capital cities in a continent where `N` is provided by the user. | Yes | Blank |
| 22   | The top `N` populated capital cities in a region where `N` is provided by the user. | Yes | Blank |
| 23   | The population of people, people living in cities, and people not living in cities in each continent. | Yes | Blank |
| 24   | The population of people, people living in cities, and people not living in cities in each region. | Yes | Blank |
| 25   | The population of people, people living in cities, and people not living in cities in each country. | Yes | Blank |
| 26   | The population of the world. | Yes | Blank |
| 27   | The population of a continent. | Yes | Blank |
| 28   | The population of a region. | Yes | Blank |
| 29    | The population of a country. | Yes | Blank |
| 30    | The population of a district. | Yes | Blank |
| 31    | The population of a city. | Yes | Blank |
| 32    | Language report displaying info for: Chinese, English, Hindi, Spanish, Arabic | Yes | Blank |

#### App URL

- local development: `http://localhost/app`
- website: `http://segeodata.duckdns.org/`

#### Command List


| Command | Description |
| - | - |
| `docker-compose up --force-recreate --renew-anon-volumes` | Start docker for local development |
| `docker-compose -f docker-compose-ci.yml up` | Start docker for ci (doesn't load spring boot) |