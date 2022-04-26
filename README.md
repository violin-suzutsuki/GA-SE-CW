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

| ID  | Name | Met | Screenshot                    |
|-----|------|-----|-------------------------------|
| 1   | All the countries in the world organised by largest population to smallest. | Yes | [Link](/report-images/1.png)  |
| 2   | All the countries in a continent organised by largest population to smallest. | Yes | [Link](/report-images/2.png)  |
| 3   | All the countries in a region organised by largest population to smallest. | Yes | [Link](/report-images/3.png)  |
| 4   | The top `N` populated countries in the world where `N` is provided by the user. | Yes | [Link](/report-images/4.png)  |
| 5   | The top `N` populated countries in a continent where `N` is provided by the user. | Yes | [Link](/report-images/5.png)  |
| 6   | The top `N` populated countries in a region where `N` is provided by the user. | Yes | [Link](/report-images/6.png)  |
| 7   | All the cities in the world organised by largest population to smallest. | Yes | [Link](/report-images/7.png)  |
| 8   | All the cities in a continent organised by largest population to smallest. | Yes | [Link](/report-images/8.png)  |
| 9   | All the cities in a region organised by largest population to smallest. | Yes | [Link](/report-images/9.png)  |
| 10  | All the cities in a country organised by largest population to smallest. | Yes | [Link](/report-images/10.png) |
| 11   | All the cities in a district organised by largest population to smallest. | Yes | [Link](/report-images/11.png) |
| 12   | The top `N` populated cities in the world where `N` is provided by the user. | Yes | [Link](/report-images/12.png) |
| 13   | The top `N` populated cities in a continent where `N` is provided by the user. | Yes | [Link](/report-images/13.png) |
| 14   | The top `N` populated cities in a region where `N` is provided by the user. | Yes | [Link](/report-images/14.png) |
| 15   | The top `N` populated cities in a country where `N` is provided by the user. | Yes | [Link](/report-images/15.png) |
| 16   | The top `N` populated cities in a district where `N` is provided by the user. | Yes | [Link](/report-images/16.png) |
| 17   | All the capital cities in the world organised by largest population to smallest. | Yes | [Link](/report-images/17.png) |
| 18  | All the capital cities in a continent organised by largest population to smallest. | Yes | [Link](/report-images/18.png) |
| 19   | All the capital cities in a region organised by largest to smallest. | Yes | [Link](/report-images/19.png) |
| 20   | The top `N` populated capital cities in the world where `N` is provided by the user. | Yes | [Link](/report-images/20.png) |
| 21   | The top `N` populated capital cities in a continent where `N` is provided by the user. | Yes | [Link](/report-images/21.png) |
| 22   | The top `N` populated capital cities in a region where `N` is provided by the user. | Yes | [Link](/report-images/22.png) |
| 23   | The population of people, people living in cities, and people not living in cities in each continent. | Yes | [Link](/report-images/23.png) |
| 24   | The population of people, people living in cities, and people not living in cities in each region. | Yes | [Link](/report-images/24.png) |
| 25   | The population of people, people living in cities, and people not living in cities in each country. | Yes | [Link](/report-images/25.png) |
| 26   | The population of the world. | Yes | [Link](/report-images/26.png) |
| 27   | The population of a continent. | Yes | [Link](/report-images/27.png) |
| 28   | The population of a region. | Yes | [Link](/report-images/28.png) |
| 29    | The population of a country. | Yes | [Link](/report-images/29.png) |
| 30    | The population of a district. | Yes | [Link](/report-images/30.png) |
| 31    | The population of a city. | Yes | [Link](/report-images/31.png) |
| 32    | Language report displaying info for: Chinese, English, Hindi, Spanish, Arabic | Yes | [Link](/report-images/32.png) |

#### App URL

- local development: `http://localhost/app`
- website: `http://segeodata.duckdns.org/`

#### Command List


| Command | Description |
| - | - |
| `docker-compose up --force-recreate --renew-anon-volumes` | Start docker for local development |
| `docker-compose -f docker-compose-ci.yml up` | Start docker for ci (doesn't load spring boot) |