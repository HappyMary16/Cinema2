import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class UpdateFilm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: new URLSearchParams(this.props.location.search).get("id"),
            title: '',
            description: '',
            year: '',
            minAge: '',
            duration: '',
            language: '',
            firstSeance: '',
            lastSeance: '',
            smallPoster: '',
            bigPoster: '',
            trailerLink: '',
            genres: [],
            directors: [],
            actors: [],
            studios: [],
            countries: [],


            userGenres: [],
            userDirectors: [],
            userActors: [],
            userStudios: [],
            userCountries: [],

            //all data for selectors
            listStudios: [],
            listCountries: [],
            listActors: [],
            listDirectors: [],
            listGenres: [],
            listLanguages: []
        }
    }

    titleChangeHandler = (name) => {
        this.setState({title: name})
    };

    descriptionChangeHandler = (name) => {
        this.setState({description: name})
    };

    yearChangeHandler = (name) => {
        this.setState({year: name})
    };

    minAgeChangeHandler = (name) => {
        this.setState({minAge: name})
    };

    durationChangeHandler = (name) => {
        this.setState({duration: name})
    };

    genresChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/genres/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                if (!this.state.userGenres.includes(response.data.genre)) {
                    this.state.genres.push(response.data);
                    this.state.userGenres.push(response.data.genre);
                    document.getElementById('selectGenre').value = this.state.userGenres;
                }
            });
    };

    directorsChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/persons/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                if (!this.state.userDirectors.includes(response.data.firstName + " " + response.data.lastName)) {
                    this.state.userDirectors.push(response.data.firstName + " " + response.data.lastName);
                    this.state.directors.push(response.data);
                    document.getElementById('selectDirector').value = this.state.userDirectors;
                }
            });
    };

    actorsChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/persons/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                if (!this.state.userActors.includes(response.data.firstName + " " + response.data.lastName)) {
                    this.state.userActors.push(response.data.firstName + " " + response.data.lastName);
                    this.state.actors.push(response.data);
                    document.getElementById('selectActor').value = this.state.userActors;
                }
            });
    };

    studiosChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/studios/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                if (!this.state.userStudios.includes(response.data.studio)) {
                    this.state.userStudios.push(response.data.studio);
                    this.state.studios.push(response.data);
                    document.getElementById('selectStudio').value = this.state.userStudios;
                }
            });
    };

    countriesChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/countries/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                if (!this.state.userCountries.includes(response.data.country)) {
                    this.state.userCountries.push(response.data.country);
                    this.state.countries.push(response.data);
                    document.getElementById('selectCountry').value = this.state.userCountries;
                }
            });
    };

    languageChangeHandler = (name) => {
        const GET_ALL_URL = "http://localhost:8080/languages/" + name;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({language: response.data})
            });
    };

    firstSeanceChangeHandler = (name) => {
        console.log(name);
        this.setState({firstSeance: name})
    };

    lastSeanceChangeHandler = (name) => {
        console.log(name);
        this.setState({lastSeance: name})
    };

    smallPosterChangeHandler = (name) => {
        console.log(name);
        this.setState({smallPoster: name})
    };

    bigPosterChangeHandler = (name) => {
        console.log(name);
        this.setState({bigPoster: name})
    };

    trailerLinkChangeHandler = (name) => {
        console.log(name);
        this.setState({trailerLink: name})
    };

    addFilmHandler = () => {
        let film = {
            title: this.state.title,
            description: this.state.description,
            minAge: this.state.minAge,
            genres: this.state.genres,
            directors: this.state.directors,
            actors: this.state.actors,
            studios: this.state.studios,
            countries: this.state.countries,
            duration: this.state.duration,
            language: this.state.language,
            firstSeance: this.state.firstSeance,
            lastSeance: this.state.lastSeance,
            smallPoster: this.state.smallPoster,
            bigPoster: this.state.bigPoster,
            trailerLink: this.state.trailerLink,
            year: this.state.year
        };
        const ADD_FILM_URL = "http://localhost:8080/films/update";
        axios.post(ADD_FILM_URL, film)
            .then(
                this.props.history.push("/film_list")
            );
    };

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/films/" + this.state.id;
        console.log("id =  " + this.state.id);
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({title: response.data.title});
                this.setState({description: response.data.description});
                this.setState({minAge: response.data.minAge});
                this.setState({year: response.data.year});
                this.setState({duration: response.data.duration});

                let userGenres = [];
                this.setState({genres: response.data.genres});
                this.state.genres.map(function (p) {
                    userGenres.push(p.genre)
                });
                this.setState({userGenres: userGenres});

                let userStudios = [];
                this.setState({studios: response.data.studios});
                this.state.studios.map(function (p) {
                    userStudios.push(p.studio)
                });
                this.setState({userStudios: userStudios});

                let userCountries = [];
                this.setState({countries: response.data.countries});
                this.state.countries.map(function (p) {
                    userCountries.push(p.country)
                });
                this.setState({userCountries: userCountries});

                let userActors = [];
                this.setState({actors: response.data.actors});
                this.state.actors.map(function (p) {
                    userActors.push(p.firstName + " " + p.lastName)
                });
                this.setState({userActors: userActors});

                let userDirectors = [];
                this.setState({directors: response.data.directors});
                this.state.directors.map(function (p) {
                    userDirectors.push(p.firstName + " " + p.lastName)
                });
                this.setState({userDirectors: userDirectors});

                this.setState({language: response.data.language});
                this.setState({firstSeance: response.data.firstSeance});
                this.setState({lastSeance: response.data.lastSeance});
                this.setState({smallPoster: response.data.smallPoster});
                this.setState({bigPoster: response.data.bigPoster});
                this.setState({trailerLink: response.data.trailerLink});
            });

        const GET_ALL_GENRES_URL = "http://localhost:8080/genres/all";
        axios.get(GET_ALL_GENRES_URL)
            .then(response => {
                this.setState({listGenres: response.data});
            });

        const GET_ALL_STUDIOS_URL = "http://localhost:8080/studios/all";
        axios.get(GET_ALL_STUDIOS_URL)
            .then(response => {
                this.setState({listStudios: response.data});
            });

        const GET_ALL_COUNTRIES_URL = "http://localhost:8080/countries/all";
        axios.get(GET_ALL_COUNTRIES_URL)
            .then(response => {
                this.setState({listCountries: response.data});
            });

        const GET_ALL_LANGUAGES_URL = "http://localhost:8080/languages/all";
        axios.get(GET_ALL_LANGUAGES_URL)
            .then(response => {
                this.setState({listLanguages: response.data});
            });

        const GET_ALL_DIRECTORS_URL = "http://localhost:8080/persons/all_directors";
        axios.get(GET_ALL_DIRECTORS_URL)
            .then(response => {
                this.setState({listDirectors: response.data});
            });

        const GET_ALL_ACTORS_URL = "http://localhost:8080/persons/all_actors";
        axios.get(GET_ALL_ACTORS_URL)
            .then(response => {
                this.setState({listActors: response.data});
            });
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="filmForm" id="content">
                    <p><label>Title:</label>
                        <input type="text" placeholder="title" value={this.state.title}
                               onChange={e => this.titleChangeHandler(e.target.value)}/></p>
                    <p><label>Description:</label>
                        <input type="text" placeholder="description" value={this.state.description}
                               onChange={e => this.descriptionChangeHandler(e.target.value)}/></p>
                    <p><label>Year:</label>
                        <input type="number" min={1800} max={new Date().getFullYear()} placeholder="year"
                               value={this.state.year}
                               onChange={e => this.yearChangeHandler(e.target.value)}/></p>
                    <p><label>Min age:</label>
                        <input type="number" min={0} max={21} placeholder="min age" value={this.state.minAge}
                               onChange={e => this.minAgeChangeHandler(e.target.value)}/></p>
                    <p><label>Duration:</label>
                        <input type="number" placeholder="duration" value={this.state.duration}
                               onChange={e => this.durationChangeHandler(e.target.value)}/></p>

                    <p><label>Language:</label>
                        <select onChange={e => this.languageChangeHandler(e.target.value)}>
                            <option value="0">Choose language</option>
                            {this.state.listLanguages.map(function (d) {
                                return (
                                    <option value={d.id}>{d.language}</option>
                                )
                            })}</select></p>

                    <p><label>Genres:</label>
                        <input type="text" id="selectGenre" value={this.state.userGenres}/>
                        <select onChange={e => this.genresChangeHandler(e.target.value)}>
                            <option value="0">Choose genre</option>
                            {this.state.listGenres.map(function (d) {
                                return (
                                    <option value={d.id}>{d.genre}</option>
                                )
                            })}</select></p>

                    <p><label>Studios:</label>
                        <input type="text" id="selectStudio" value={this.state.userStudios}/>
                        <select onChange={e => this.studiosChangeHandler(e.target.value)}>
                            <option value="0">Choose studio</option>
                            {this.state.listStudios.map(function (d) {
                                return (
                                    <option value={d.id}>{d.studio}</option>
                                )
                            })}</select></p>

                    <p><label>Countries:</label>
                        <input type="text" id="selectCountry" value={this.state.userCountries}/>
                        <select onChange={e => this.countriesChangeHandler(e.target.value)}>
                            <option value="0">Choose countries</option>
                            {this.state.listCountries.map(function (d) {
                                return (
                                    <option value={d.id}>{d.country}</option>
                                )
                            })}</select></p>

                    <p><label>Directors:</label>
                        <input type="text" id="selectDirector" value={this.state.userDirectors}/>
                        <select onChange={e => this.directorsChangeHandler(e.target.value)}>
                            <option value="0">Choose director</option>
                            {this.state.listDirectors.map(function (d) {
                                return (
                                    <option value={d.id}>{d.firstName} {d.lastName}</option>
                                )
                            })}</select></p>

                    <p><label>Actors:</label>
                        <input type="text" id="selectActor" value={this.state.userActors}/>
                        <select onChange={e => this.actorsChangeHandler(e.target.value)}>
                            <option value="0">Choose actor</option>
                            {this.state.listActors.map(function (d) {
                                return (
                                    <option value={d.id}>{d.firstName} {d.lastName}</option>
                                )
                            })}</select></p>
                    <p><label>First seance:</label>
                        <input type="date" value={this.state.firstSeance}
                               onChange={e => this.firstSeanceChangeHandler(e.target.value)}/></p>
                    <p><label>Last seance:</label>
                        <input type="date" value={this.state.lastSeance}
                               onChange={e => this.lastSeanceChangeHandler(e.target.value)}/></p>
                    <p><label>Small poster (link):</label>
                        <input type="text" value={this.state.smallPoster}
                               onChange={e => this.smallPosterChangeHandler(e.target.value)}/></p>
                    <p><label>Big poster (link):</label>
                        <input type="text" value={this.state.bigPoster}
                               onChange={e => this.bigPosterChangeHandler(e.target.value)}/></p>
                    <p><label>Trailer (link):</label>
                        <input type="text" value={this.state.trailerLink}
                               onChange={e => this.trailerLinkChangeHandler(e.target.value)}/></p>

                    <p>
                        <button type="submit" onClick={this.addFilmHandler}>Update film</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default UpdateFilm;