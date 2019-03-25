import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class SeanceList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            seances: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/seances/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({seances: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/seances/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({seances: response.data});
            })
    }

    onClickHandler = () => {
        this.props.history.push("/add_seance")
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="allSeances" id="content">
                    <h1>Seances</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Film</th>
                            <th className="title">Data</th>
                            <th className="title">Hall</th>
                            <th className="title">Price</th>
                        </tr>
                        {this.state.seances.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td><a href={"seance_card?id=" + d.id}>
                                        {idx + 1}
                                    </a></td>
                                    <td><a href={"film_card?id=" + d.id}>
                                        {d.film.title}
                                    </a></td>
                                    <td>{d.dateAndTime}</td>
                                    <td><a href={"hall_card?id=" + d.id}>
                                        {d.hall.name}
                                    </a></td>
                                    <td>{d.priceTicket}</td>
                                </tr>
                            )
                        })}
                    </table>

                    <p>
                        <button onClick={this.onClickHandler}>Add seance</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default SeanceList;