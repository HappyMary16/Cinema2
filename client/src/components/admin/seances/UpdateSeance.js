import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataForm.css'

class UpdateSeance extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: new URLSearchParams(this.props.location.search).get("id"),
            film: null,
            filmId: '',
            dateAndTime: null,
            hall: null,
            hallId: '',
            priceTicket: '',

            films: [],
            halls: []
        }
    }

    filmChangeHandler = (name) => {
        this.setState({filmId: name});
        const GET_FILM_URL = "http://localhost:8080/films/" + this.state.filmId;
        axios.get(GET_FILM_URL)
            .then(response => {
                this.setState({film: response.data})
            });

    };

    dateChangeHandler = (name) => {
        if (this.state.dateAndTime === null) {
            this.setState(state => ({
                ...state,
                dateAndTime: null,
            }), () => {

            });

            this.setState({dateAndTime: name});
        }
    };

    timeChangeHandler = (name) => {
        if (this.state.dateAndTime === null) {
            this.setState(state => ({
                ...state,
                dateAndTime: null,
            }), () => {

            });

            this.setState({dateAndTime: name});
        }

        console.log(this.state.dateAndTime);
    };

    hallChangeHandler = (name) => {
        this.setState({hallId: name});
        const GET_HALL_URL = "http://localhost:8080/halls/" + this.state.hallId;
        axios.get(GET_HALL_URL)
            .then(response => {
                this.setState({hall: response.data})
            });
    };
    priceTicketChangeHandler = (name) => {
        this.setState({priceTicket: name})
    };

    componentWillMount() {
        const GET_ALL_FILMS_URL = "http://localhost:8080/films/all";
        axios.get(GET_ALL_FILMS_URL)
            .then(response => {
                this.setState({films: response.data});
            });

        const GET_ALL_HALLS_URL = "http://localhost:8080/halls/all";
        axios.get(GET_ALL_HALLS_URL)
            .then(response => {
                this.setState({halls: response.data});
            });

        const GET_SEANCE_URL = "http://localhost:8080/seances/" + this.state.id;
        axios.get(GET_SEANCE_URL)
            .then(response => {
                this.setState({filmId: response.data.film.id});
                this.setState({hallId: response.data.hall.id});
                this.setState({film: response.data.film});
                this.setState({hall: response.data.hall});
                this.setState({dateAndTime: response.data.dateAndTime});
                this.setState({priceTicket: response.data.priceTicket})
            });
    }

    addSeanceHandler = () => {
        debugger;

        let seance = {
            film: this.state.film,
            dateAndTime: this.state.dateAndTime,
            hall: this.state.hall,
            priceTicket: this.state.priceTicket
        };

        const ADD_SEANCE_URL = "http://localhost:8080/seances/add";
        axios.post(ADD_SEANCE_URL, seance)
            .then(this.props.history.push("/seance_list"));
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="seanceForm" id="content">
                    <p><label>Film:</label>
                        <select onChange={e => this.filmChangeHandler(e.target.value)} value={this.state.filmId}>
                            {this.state.films.map(function (d) {
                                return (
                                    <option value={d.id}>{d.title}</option>
                                )
                            })}
                        </select></p>

                    <p><label>Date:</label>
                        <input type="date" onChange={e => this.dateChangeHandler(e.target.value)} value={this.state.dateAndTime}/></p>
                    <p><label>Time:</label>
                        <input type="time" onChange={e => this.timeChangeHandler(e.target.value)} value={this.state.dateAndTime}/></p>

                    <p><label>Hall:</label>
                        <select onChange={e => this.hallChangeHandler(e.target.value)} value={this.state.hallId}>
                            {this.state.halls.map(function (d) {
                                return (
                                    <option value={d.id}>{d.name}</option>
                                )
                            })}
                        </select></p>
                    <p><label>Price:</label>
                        <input type="number" onChange={e => this.priceTicketChangeHandler(e.target.value)} value={this.state.priceTicket}/></p>

                    <p>
                        <button type="submit" onClick={this.addSeanceHandler}>Add seance</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default UpdateSeance;