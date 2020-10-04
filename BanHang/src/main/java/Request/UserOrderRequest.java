package Request;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserOrderRequest {
	private int userId;

    private List<ProductOrderRequest> listOrder;
    
    
    public UserOrderRequest() {
    	
    }

	

	public UserOrderRequest(int userId, List<ProductOrderRequest> listOrder) {
		
		this.userId = userId;
		this.listOrder = listOrder;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public List<ProductOrderRequest> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<ProductOrderRequest> listOrder) {
		this.listOrder = listOrder;
	}
}
