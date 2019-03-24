import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class SeanceCard extends Component {
    constructor(props) {
        super(props);

        this.state = {
            seance : {
                film: {
                    id: '',
                    title: ''
                },
                dateAndTime: null,
                hall: {
                    id: '',
                    title: ''
                },
                priceTicket: ''
            },
            id: new URLSearchParams(this.props.location.search).get("id")
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/seances/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({seance: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/seances/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({seance: response.data});
            })
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="allSeances" id="content">
                    <p><label htmlFor="film">Film:</label>
                        <input type="text" name="film" id="film" value={this.state.seance.film.title} readOnly/>
                    </p>
                    <p><label>Date:</label>
                        <input type="date" value={this.state.seance.dateAndTime} readOnly/></p>
                    <p><label>Date:</label>
                        <input type="time" value={this.state.seance.dateAndTime} readOnly/></p>
                    <p><label htmlFor="phoneField">Hall:</label>
                        <input type="text" name="hall" id="hall" value={this.state.seance.hall.name} readOnly/></p>
                    <p><label htmlFor="price">Price:</label>
                        <input type="number" name="price" id="price" value={this.state.seance.priceTicket} readOnly/></p>

                    <p>
                        <a href={"/seance_update?id=" + this.state.id}>Update</a>
                    </p>
                </div>
            </div>
        );
    }
}

export default SeanceCard;