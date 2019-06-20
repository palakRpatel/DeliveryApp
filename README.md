# NYListApp

NYTimeListActivity
 - NYTimeListPresenter : Main Java logic
 - NYTimeListContract  : Interface between presenter and view
 
To call web services I have use Repository Pattern with volley library.

- NYTimeListRepository : Call to webservice 
- NYTimeListRemoteDataSource : Actuall volley call implementation
- NYtimeDataSource  : contains interface for listeners and method interface.

Adapter
- NYListAdapter : Initialize binders and layout.
- NYListAdapterContract : connector between presenter and view
- NYListViewHolder : ViewHolder
- NYListPresenter : core Java code

Data Pojo
- NYListResponse 
- Result


