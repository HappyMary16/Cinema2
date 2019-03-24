import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class HallCard extends Component {
    constructor(props) {
        super(props);

        this.state = {
            hall: {},
            placement: [],
            id: new URLSearchParams(this.props.location.search).get("id")
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/halls/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({hall: response.data});
                this.setState({placement: response.data.placement})
            });
        console.log(this.state.placement);
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/halls/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({hall: response.data});
            })
    }

    createHallPlacement() {
        let table = [];
        for (let i = 0; i < this.state.hall.height; i++) {
            let children = [];
            for (let j = 0; j < this.state.hall.width; j++) {
                if (this.state.placement[i][j]) {
                    children.push(<td><input type="button"/></td>)
                } else {
                    children.push(<td><p></p></td>)
                }
            }
            table.push(<tr>{children}</tr>)
        }
        return table;
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="allUsers" id="content">
                    <p><label htmlFor="name">Name:</label>
                        <input type="text" name="name" id="name" value={this.state.hall.name} readOnly/>
                    </p>
                    <p><label htmlFor="width">Width:</label>
                        <input type="number" name="width" id="width" value={this.state.hall.width} readOnly/></p>
                    <p><label htmlFor="height">Number rows:</label>
                        <input type="number" name="height" id="height" value={this.state.hall.height} readOnly/></p>
                    {/*<p><label htmlFor="numberPlaces">Number places:</label>*/}
                    {/*<input type="text" name="numberPlaces" id="numberPlaces"*/}
                    {/*value={this.state.hall.places.length} readOnly/></p>*/}

                    <table>
                        {this.createHallPlacement()}
                    </table>
                    <p>
                        <a href={"/add_placement?id=" + this.state.id}>Add placement</a>
                    </p>
                    <p>
                        <a href={"/hall_update?id=" + this.state.id}>Update</a>
                    </p>
                </div>
            </div>
        );
    }
}

export default HallCard;