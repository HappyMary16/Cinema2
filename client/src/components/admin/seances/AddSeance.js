import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataForm.css'

class AddSeance extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            film: null,
            filmId: '1',
            dateAndTime: null,
            hall: null,
            hallId: '1',
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
        console.log(this.state.dateAndTime);
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

        const GET_FILM_URL = "http://localhost:8080/films/" + this.state.filmId;
        axios.get(GET_FILM_URL)
            .then(response => {
                this.setState({film: response.data})
            });

        const GET_HALL_URL = "http://localhost:8080/halls/" + this.state.hallId;
        axios.get(GET_HALL_URL)
            .then(response => {
                this.setState({hall: response.data})
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
                        <select onChange={e => this.filmChangeHandler(e.target.value)}>
                        {this.state.films.map(function (d) {
                            return (
                                <option value={d.id}>{d.title}</option>
                            )
                        })}
                    </select></p>

                    <p><label>Date:</label>
                        <input type="date" onChange={e => this.dateChangeHandler(e.target.value)}/></p>
                    <p><label>Time:</label>
                        <input type="time" onChange={e => this.timeChangeHandler(e.target.value)}/></p>

                    <p><label>Hall:</label>
                        <select onChange={e => this.hallChangeHandler(e.target.value)}>
                            {this.state.halls.map(function (d) {
                                return (
                                    <option value={d.id}>{d.name}</option>
                                )
                            })}
                        </select></p>
                    <p><label>Price:</label>
                        <input type="number" onChange={e => this.priceTicketChangeHandler(e.target.value)}/></p>

                    <p>
                        <button type="submit" onClick={this.addSeanceHandler}>Add seance</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddSeance;