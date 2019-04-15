export interface NearbyPlaces {


    "html_attributions": Array<string>,
    "next_page_token": string,
    "results": Array<
        {
            "geometry": {
                "location": {
                    "lat": number,
                    "lng": number
                },
                "viewport": {
                    "northeast": {
                        "lat": number,
                        "lng": number
                    },
                    "southwest": {
                        "lat": number,
                        "lng": number
                    }
                }
            },
            "icon": string,
            "id": string,
            "name": string,
            "opening_hours": {
                "open_now": boolean
            },
            "photos": Array<
                {
                    "height": number,
                    "html_attributions": Array<string>,
                    "photo_reference":string,
                    "width": number
                }
            >,
            "place_id": string,
            "plus_code": {
                "compound_code": string,
                "global_code": string 
            },
            "price_level": number,
            "rating": number,
            "reference": string,
            "scope": string,
            "types": Array<string>,
            "user_ratings_total": number,
            "vicinity": string
        }
    >
    "status": string
}

