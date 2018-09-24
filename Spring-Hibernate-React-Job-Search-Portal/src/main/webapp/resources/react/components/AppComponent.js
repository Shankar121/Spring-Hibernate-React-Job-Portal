class AppComponent extends React.Component {
constructor(props) {
    	    super(props);
    	    this.state={showAdvanceSearch:false,serachText:'',jobDetails:[],yoeL:0,yoeR:1,allLocation:[]}
    }

componentWillMount(){
	var that = this;
	var url = reactBaseUrl + 'allJobs'
	var params={};
	$.post( url,params,function( data ) {
		console.log(JSON.stringify(data));
		that.setState({
			jobDetails:JSON.parse(data.jobDetails),
			allLocation:data.allLocation
		});
		
	});
}




advanceSearch(){
	this.setState({showAdvanceSearch:true});
}

searchByType(){
	var type="";
	var k=1;
	var len=$(".job-type").length-1;
	$(".job-type").each(function(){
		if($(this).is(":checked")){
			if(parseInt(k)==parseInt(len)){
				type+=$(this).val();
			}else{
				type+=$(this).val()+",";
			}
		}
		
	});
	console.log(type);
	var that = this;
	var url = reactBaseUrl + 'searchByType'
	var params={type:type};
	$.post( url,params,function( data ) {
		console.log(JSON.stringify(data));
		that.setState({
			jobDetails:JSON.parse(data.jobDetails)
		});
	});
}

searchByExp(e){
	
	var yoeLower=$("#yoeL").val();
	var yoeUpper=$("#yoeR").val();
	
	if(e.target.name=="yoeL"){
		this.setState({yoeL:e.target.value});
	}else{
		this.setState({yoeR:e.target.value});
	}
	if(yoeLower.length>0 && yoeUpper.length>0 && (!isNaN(yoeLower) && !isNaN(yoeUpper))){
		var that = this;
		var url = reactBaseUrl + 'searchByExp'
		var params={yoeLower:yoeLower,yoeUpper:yoeUpper};
		$.post( url,params,function( data ) {
			console.log(JSON.stringify(data));
			that.setState({
				jobDetails:JSON.parse(data.jobDetails)
			});
		});
	}
}

searchByKeywordFilter(e){
	this.setState({serachText:e.target.value});
	var that = this;
	var url = reactBaseUrl + 'searchByKeyword'
	var params={searchText:e.target.value};
	$.post( url,params,function( data ) {
		console.log(JSON.stringify(data));
		that.setState({
			jobDetails:JSON.parse(data.jobDetails)
		});
	});
}

searchByLoc(e){
	var location=e.target.value;
	var that = this;
	var url = reactBaseUrl + 'searchByLoc'
	var params={location:location};
	$.post( url,params,function( data ) {
		console.log(JSON.stringify(data));
		that.setState({
			jobDetails:JSON.parse(data.jobDetails)
		});
	});
}

renderFilter(){
 	return(
			<div id="filterContent">
			<div className="row">
				<div className="col-md-2">
				  <input type="text" className="form-control" placeholder="Search Job" value={this.state.serachText} onChange={this.searchByKeywordFilter.bind(this)} name="search" id="search"/>
				</div>
				<div className="col-md-2">
				 <input type="checkbox" className="job-type" value="-1" /> All
				</div>
				 <div className="col-md-2">
				 <input type="checkbox" className="job-type" value="Full Time" /> Full Time
				</div>
				 <div className="col-md-2">
				 <input type="checkbox" className="job-type" value="Part Time" /> Part Time
				</div>
				 <div className="col-md-2">
				 <input type="checkbox" className="job-type" value="Freelancer" /> Freelancer
				</div>
				 <div className="col-md-2">
				 <button className="btn btn-small btn-primary" onClick={this.searchByType.bind(this)}>Search</button>
				</div>
		</div>
		<div className="row m-t-10 m-b-10">
			<div className="col-md-6">
			  <a href="javascript:void(0);" style={{fontSize:'14px'}} onClick={this.advanceSearch.bind(this)}>Advance Search</a>
			</div>
	    </div>
	    { this.state.showAdvanceSearch ?
		<div className="row" ref="advanceSearchDiv">
			<div className="col-md-2">
			 <p>Filter By Location</p>
			  <select id="location" onChange={this.searchByLoc.bind(this)}>
			  <option value="-1">All</option>
			  {this.state.allLocation.map((loc,i)=>
	      		<option key={20*i} value={loc}>{loc}</option>
	      	   )}
			  </select>
			</div>
			<div className="col-md-8">
			 <p>Filter By years of experience</p>
			 <input type="text" className="form-control exp-input" onChange={this.searchByExp.bind(this)} id="yoeL"  name="yoeL" value={this.state.yoeL} /> - <input type="text" onChange={this.searchByExp.bind(this)} className="form-control exp-input"  name="yoeR" id="yoeR"  value={this.state.yoeR} />
			</div>
		</div>
		:""}
		</div>
	)
}

render(){
  
    	return(
    			<div>
               {this.renderFilter()}
		       <JobComponent data={this.state.jobDetails} />
			</div>
		)
	
}

}