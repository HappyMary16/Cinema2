import React, {Component} from 'react';
import axios from 'axios';

class AddCountry extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: '',
            country: ''
        }
    }

    countryChangeHandler = (name) => {
        this.setState({country: name})
    };

    addCountryHandler = () => {
        let country = {
            country: this.state.country
        };
        const ADD_COUNTRY_URL = "http://localhost:8080/countries/add";
        if (this.state.country.match(/(\w ?)+/)) {
            axios.post(ADD_COUNTRY_URL, country)
                .then(this.props.history.push("/country_list"));
        }
    };
    render() {
        return (
            <div className="wrapper">
                <div className="countryForm" id="content">
                    <p><input type="text" placeholder="country"
                              onChange={e => this.countryChangeHandler(e.target.value)}/></p>
                    <p>
                        <button type="submit" onClick={this.addCountryHandler}>Add country</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AddCountry;