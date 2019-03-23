import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class FilmCard extends Component {
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
            userGenres: [],
            userDirectors: [],
            userActors: [],
            userStudios: [],
            userCountries: [],
            genres: [],
            directors: [],
            actors: [],
            studios: [],
            countries: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/films/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({title: response.data.title});
                this.setState({description: response.data.description});
                this.setState({minAge: response.data.minAge});
                this.setState({year: response.data.year});
                this.setState({duration: response.data.duration});
                this.setState({language: response.data.language.language});
                this.setState({firstSeance: response.data.firstSeance});
                this.setState({lastSeance: response.data.lastSeance});
                this.setState({smallPoster: response.data.smallPoster});
                this.setState({bigPoster: response.data.bigPoster});
                this.setState({trailerLink: response.data.trailerLink});

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
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="filmForm" id="content">
                    <p><label>Title:</label>
                        <input type="text" value={this.state.title} readOnly/></p>
                    <p><label>Description:</label>
                        <input type="text" value={this.state.description} readOnly/></p>
                    <p><label>Year:</label>
                        <input type="number" value={this.state.year}
                               readOnly/></p>
                    <p><label>Min age:</label>
                        <input type="number" value={this.state.minAge} readOnly/></p>
                    <p><label>Duration:</label>
                        <input type="number" value={this.state.duration} readOnly/></p>

                    <p><label>Language:</label>
                        <input type="text" value={this.state.language} readOnly/></p>

                    <p><label>Genres:</label>
                        <input type="text" id="selectGenre" value={this.state.userGenres} readOnly/></p>

                    <p><label>Studios:</label>
                        <input type="text" id="selectStudio" value={this.state.userStudios} readOnly/></p>

                    <p><label>Countries:</label>
                        <input type="text" id="selectCountry" value={this.state.userCountries} readOnly/></p>

                    <p><label>Directors:</label>
                        <input type="text" id="selectDirector" value={this.state.userDirectors} readOnly/></p>

                    <p><label>Actors:</label>
                        <input type="text" id="selectActor" value={this.state.userActors} readOnly/></p>
                    <p><label>First seance:</label>
                        <input type="date" value={this.state.firstSeance} readOnly/></p>
                    <p><label>Last seance:</label>
                        <input type="date" value={this.state.lastSeance} readOnly/></p>
                    <p><label>Small poster (link):</label>
                        <input type="text" value={this.state.smallPoster} readOnly/></p>
                    <p><label>Big poster (link):</label>
                        <input type="text" value={this.state.bigPoster} readOnly/></p>
                    <p><label>Trailer (link):</label>
                        <input type="text" value={this.state.trailerLink} readOnly/></p>

                    <p>
                        <a href={"/film_update?id=" + this.state.id}>Update</a>
                    </p>
                </div>
            </div>
        );
    }
}

export default FilmCard;